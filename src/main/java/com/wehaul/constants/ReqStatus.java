package com.wehaul.constants;

public enum ReqStatus {
	NEW("NEW"), OPEN("OPEN"), QUOTED("QUOTED"), CLOSED("CLOSED"), EXPIRED("EXPIRED");

	private String status;

	private ReqStatus(String reqStatus) {
		this.status = reqStatus;
	}

	public String getStatus() {
		return status;
	}
}
