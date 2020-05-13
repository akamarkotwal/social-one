package org.akcap.socialone.util;

import java.util.List;

public class ResponseMessage<T> {
	private Integer statuscode;
	private String status;
	private String message;
	private List<T> data;
	public ResponseMessage() {
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
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResponseMessage [statuscode=" + statuscode + ", status=" + status + ", message=" + message + ", data="
				+ data + "]";
	}
	
	

}
