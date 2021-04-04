package com.javamastermind.com.sms.domain;

public class ErrorResponse {

	private String message;
	private String responseCode;

	public String getMessage() {
		return message;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}


}
