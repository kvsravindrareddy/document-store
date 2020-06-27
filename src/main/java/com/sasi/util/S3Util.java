package com.sasi.util;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Component
public class S3Util {
	
	@Autowired
	private AmazonS3 amazonS3;
	
	public void createBucket(String bucketName)
    {
        System.out.println("*****Before creating bucket*****");
        boolean flag = false;
        for (Bucket bucket : amazonS3.listBuckets()) {
            if(!flag && bucket.getName().equals(bucketName))
            {
                flag = true;
                break;
            }
        }
        if(!flag)
        {
            System.out.println("*******Bucket not exist******");
            amazonS3.createBucket(bucketName);
        }
        System.out.println("*****After creating bucket*****");
    }

    public void uploadObject(String bucketName,String fileName, byte[] fileBytes, String contentType)
    {
        System.out.println("before uploading file");
        try {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(contentType);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(fileBytes);
        PutObjectRequest request = new PutObjectRequest(bucketName, fileName, byteArrayInputStream, metadata);
        amazonS3.putObject(request);
        } catch (AmazonServiceException ase){
            ase.printStackTrace();
        } catch (SdkClientException sce){
            sce.printStackTrace();
        }
        System.out.println("File uploaded successfully");
    }
}