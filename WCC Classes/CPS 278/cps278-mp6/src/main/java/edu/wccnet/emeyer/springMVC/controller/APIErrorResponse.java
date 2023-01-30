package edu.wccnet.emeyer.springMVC.controller;

public class APIErrorResponse {

	private int statue;
	private String message;
	private long timeStamp;
	
	public APIErrorResponse() {
		
	}

	public int getStatue() {
		return statue;
	}

	public void setStatue(int statue) {
		this.statue = statue;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "StudenterrorResponse [statue=" + statue + ", message=" + message + ", timeStamp=" + timeStamp + "]";
	}

	public APIErrorResponse(int statue, String message, long timeStamp) {
		super();
		this.statue = statue;
		this.message = message;
		this.timeStamp = timeStamp;
	}
	
}
