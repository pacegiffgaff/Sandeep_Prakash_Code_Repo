package com.giffgaff.ims.model;

public class MessageBean {

	private String message;
	private String errorCode;

	public MessageBean() {

	}

	public MessageBean(String message) {
		this.message = message;
	}

	public MessageBean(String message, String errorCode) {
		this(message);
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
