package edu.wccnet.emeyer.springMVC.controller;

public class NotFoundException extends RuntimeException {

	public NotFoundException(String msg) {
		super(msg);
	}
}
