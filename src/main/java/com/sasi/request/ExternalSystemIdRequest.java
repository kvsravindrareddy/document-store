package com.sasi.request;

public class ExternalSystemIdRequest {
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