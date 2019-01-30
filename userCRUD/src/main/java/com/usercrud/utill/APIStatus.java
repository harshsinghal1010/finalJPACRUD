package com.usercrud.utill;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class APIStatus<H> {

	private String status;
	private String message;
	private H entity;
	
	public APIStatus(String status, String message, H entity) {
		super();
		this.status = status;
		this.message = message;
		this.entity = entity;
	}
	public String getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public H getEntity() {
		return entity;
	}
	
	
}
