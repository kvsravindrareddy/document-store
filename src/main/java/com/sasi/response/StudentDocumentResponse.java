package com.sasi.response;

import java.io.Serializable;

public class StudentDocumentResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2742910818189985453L;
	private String id;
	private String personId;
	private String documentCode;
	private String documentType;
	private String sourceSystem;
	private String documentURI;
	private String storage;
	private String accesscontrol;
	private String documentName;
	private String client;
	private ExternalSystemId externalSystemId;
	private String status;
	private MetaData metaData;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getSourceSystem() {
		return sourceSystem;
	}
	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}
	public String getDocumentURI() {
		return documentURI;
	}
	public void setDocumentURI(String documentURI) {
		this.documentURI = documentURI;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage = storage;
	}
	public String getAccesscontrol() {
		return accesscontrol;
	}
	public void setAccesscontrol(String accesscontrol) {
		this.accesscontrol = accesscontrol;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public ExternalSystemId getExternalSystemId() {
		return externalSystemId;
	}
	public void setExternalSystemId(ExternalSystemId externalSystemId) {
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

class ExternalSystemId
{
	private long systemId;
	private String system;
	public long getSystemId() {
		return systemId;
	}
	public void setSystemId(long systemId) {
		this.systemId = systemId;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
}

class FormData {
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