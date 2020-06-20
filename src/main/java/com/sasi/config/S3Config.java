package com.sasi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.sasi.data.AWSConfigData;

@Configuration
public class S3Config {

    @Autowired
    private AWSConfigData appData;

    @Bean
    public AmazonS3 connectAmazonS3()
    {
        System.out.println("---Connected AWS S3---");
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(appData.getAccessKey(), appData.getSecretKey())))
                .withRegion("ap-south-1")
                .build();
    }
}