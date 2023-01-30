package edu.wccnet.emeyer.studentApp.controller;

public class StudentNotFoundException extends RuntimeException {

	public StudentNotFoundException(String msg) {
		super(msg);
	}
}
