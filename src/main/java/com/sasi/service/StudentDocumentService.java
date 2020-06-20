package com.sasi.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.sasi.data.AWSConfigData;
import com.sasi.entity.ExternalSystemIdEntity;
import com.sasi.entity.StudentDocumentEntity;
import com.sasi.repo.StudentDocumentRepo;
import com.sasi.request.StudentDocumentRequest;
import com.sasi.util.S3Util;

@Service
public class StudentDocumentService {
	
	@Autowired
	private StudentDocumentRepo documentRepo;
	
	@Autowired
	private S3Util s3Util;
	
	@Value("${aws.bucket-name}")
	private String s3bucket;
	
	@Autowired
	private AWSConfigData awsConfigData;

	public String uploadDocument(MultipartFile file, String personId) {
		try {
			byte[] fileBytes = file.getBytes();
			s3Util.createBucket(awsConfigData.getBucketName());
			System.out.println("File Content Type : "+file.getContentType());
			s3Util.uploadObject(awsConfigData.getBucketName()+"/"+personId, file.getOriginalFilename(), fileBytes, file.getContentType());
		} catch (IOException io) {
			io.printStackTrace();
		}
		return "s3://"+s3bucket+"/"+personId+"/"+file.getOriginalFilename();
	}

	public void createStudentDocument(StudentDocumentRequest studentDocument) {
		String s3Url = studentDocument.getS3url();
		String documentName = s3Url.substring(s3Url.lastIndexOf("/")+1);
		Gson gson = new Gson();
		//convert request to entity
		StudentDocumentEntity entity = new StudentDocumentEntity();
		entity.setPersonId(studentDocument.getPersonId());
		entity.setDocumentCode(studentDocument.getDocumentCode());
		entity.setDocumentType(s3Url.substring(s3Url.lastIndexOf(".")+1));
		entity.setSourceSystem(studentDocument.getSourceSystem());
		entity.setDocumentURI(s3Url);
		entity.setStorage("S3");
		entity.setAccesscontrol(studentDocument.getAccesscontrol());
		entity.setDocumentName(documentName);
		entity.setClient(studentDocument.getClient());
		entity.setExternalSystemId(gson.fromJson(gson.toJson(studentDocument.getExternalSystemId()), ExternalSystemIdEntity.class));
		
		entity.setCloudFrontURI(awsConfigData.getCloudfrontBaseUri()+"/"+studentDocument.getPersonId()+"/"+documentName);
		documentRepo.save(entity);
	}

	public Iterable<StudentDocumentEntity> getStudentDocuments() {
		return documentRepo.findAll();
	}
	
	public static void main(String[] args) {
		String s3Url = "s3://test/test.pdf";
		System.out.println(s3Url.substring(s3Url.lastIndexOf("/")+1));
	}

	public Optional<StudentDocumentEntity> getStudentDocument(String personId) {
		return documentRepo.findByPersonId(personId);
	}
}