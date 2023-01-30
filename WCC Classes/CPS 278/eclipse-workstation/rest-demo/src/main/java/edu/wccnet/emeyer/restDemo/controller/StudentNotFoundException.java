package edu.wccnet.emeyer.restDemo.controller;

public class StudentNotFoundException extends RuntimeException {

	public StudentNotFoundException(String msg) {
		super(msg);
	}
}
