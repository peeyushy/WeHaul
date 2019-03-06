package com.erwebadmin.constants;

public enum ReqStatus {
	NEW("NEW"), OPEN("OPEN"), CLOSED("CLOSED"), EXPIRED("EXPIRED");

	private String status;

	private ReqStatus(String reqStatus) {
		this.status = reqStatus;
	}

	public String getStatus() {
		return status;
	}
}
