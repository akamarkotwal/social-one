package org.akcap.socialone.util;

import java.util.List;

public class SingaleResponceMessages<T> {
	private Integer statuscode;
	private String status;
	private String message;
	private Object data;
	public SingaleResponceMessages() {
		super();
	}
	public Integer getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(Integer statuscode) {
		this.statuscode = statuscode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	

}
