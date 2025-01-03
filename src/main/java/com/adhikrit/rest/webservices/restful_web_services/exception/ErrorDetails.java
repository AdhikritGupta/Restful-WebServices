package com.adhikrit.rest.webservices.restful_web_services.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
//	timestamp
	private LocalDateTime timestamp;
//	message
	private String message;
//	details
	private String detail;
	public ErrorDetails(LocalDateTime timestamp, String message, String detail) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.detail = detail;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
	public String getMessage() {
		return message;
	}
	public String getDetail() {
		return detail;
	}
}
