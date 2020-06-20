package com.sasi.data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "aws")
public class AWSConfigData {
    private String accessKey;
    private String secretKey;
    private String bucketName;
    private String region;
    private String cloudfrontBaseUri;
    
	public String getAccessKey() {
		return accessKey;
	}
	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}
	public String getSecretKey() {
		return secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	public String getBucketName() {
		return bucketName;
	}
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCloudfrontBaseUri() {
		return cloudfrontBaseUri;
	}
	public void setCloudfrontBaseUri(String cloudfrontBaseUri) {
		this.cloudfrontBaseUri = cloudfrontBaseUri;
	}
}