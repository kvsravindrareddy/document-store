package com.sasi.request;

import java.io.Serializable;


public class StudentDocumentRequest {
	private String personId;
	private String s3url;
	private String documentCode;
	private String sourceSystem;
	private String accesscontrol;
	private String client;
	private String formData;
	private ExternalSystemIdRequest externalSystemId;
	private String status;
	private MetaData metaData;
	
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getDocumentCode() {
		return documentCode;
	}
	public void setDocumentCode(String documentCode) {
		this.documentCode = documentCode;
	}
	public String getSourceSystem() {
		return sourceSystem;
	}
	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}
	public String getAccesscontrol() {
		return accesscontrol;
	}
	public void setAccesscontrol(String accesscontrol) {
		this.accesscontrol = accesscontrol;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getFormData() {
		return formData;
	}
	public void setFormData(String formData) {
		this.formData = formData;
	}
	public ExternalSystemIdRequest getExternalSystemId() {
		return externalSystemId;
	}
	public void setExternalSystemId(ExternalSystemIdRequest externalSystemId) {
		this.externalSystemId = externalSystemId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public MetaData getMetaData() {
		return metaData;
	}
	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}
	public String getS3url() {
		return s3url;
	}
	public void setS3url(String s3url) {
		this.s3url = s3url;
	}	
}

class FormData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8160272365091694995L;
	private String AC59;
	private String AC79;
	private String DocumentOwner;
	private int age;
	private RecipientSetInfos recipientSetInfos;
	public String getAC59() {
		return AC59;
	}
	public void setAC59(String aC59) {
		AC59 = aC59;
	}
	public String getAC79() {
		return AC79;
	}
	public void setAC79(String aC79) {
		AC79 = aC79;
	}
	public String getDocumentOwner() {
		return DocumentOwner;
	}
	public void setDocumentOwner(String documentOwner) {
		DocumentOwner = documentOwner;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public RecipientSetInfos getRecipientSetInfos() {
		return recipientSetInfos;
	}
	public void setRecipientSetInfos(RecipientSetInfos recipientSetInfos) {
		this.recipientSetInfos = recipientSetInfos;
	}
}

class RecipientSetInfos
{
	private RecipientSetMemberInfos recipientSetMemberInfos;
	private String recipientSetRole;
	public RecipientSetMemberInfos getRecipientSetMemberInfos() {
		return recipientSetMemberInfos;
	}
	public void setRecipientSetMemberInfos(RecipientSetMemberInfos recipientSetMemberInfos) {
		this.recipientSetMemberInfos = recipientSetMemberInfos;
	}
	public String getRecipientSetRole() {
		return recipientSetRole;
	}
	public void setRecipientSetRole(String recipientSetRole) {
		this.recipientSetRole = recipientSetRole;
	}
}

class RecipientSetMemberInfos
{
	private String email;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}

class MetaData
{
	private String Program;

	public String getProgram() {
		return Program;
	}
	public void setProgram(String program) {
		Program = program;
	}
}