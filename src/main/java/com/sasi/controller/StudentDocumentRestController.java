package com.sasi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sasi.entity.StudentDocumentEntity;
import com.sasi.request.StudentDocumentRequest;
import com.sasi.service.StudentDocumentService;

@RestController
@RequestMapping("/student")
public class StudentDocumentRestController {

	@Autowired
	private StudentDocumentService documentService;

	/**
	 * Upload file and return the s3 url if the file successfully uploaded
	 * @param file
	 * @param personId
	 * @return
	 */
	@PostMapping("/document")
	public String uploadDocument(@RequestPart("file") MultipartFile file, @RequestParam("personId") String personId) {
		return documentService.uploadDocument(file, personId);
	}

	/**
	 * 
	 * @param studentDocument
	 * @param s3url
	 */
	@PostMapping(value = "/createdocument")
	public void createStudentDocument(@RequestBody StudentDocumentRequest studentDocument) {
		documentService.createStudentDocument(studentDocument);
	}

	@GetMapping("/document")
	public Iterable<StudentDocumentEntity> getStudentDocuments() {
		return documentService.getStudentDocuments();
	}
	
	@GetMapping("/getdocument")
	public Optional<StudentDocumentEntity> getStudentDocument(@RequestParam("personId") String personId)
	{
		return documentService.getStudentDocument(personId);
	}
}