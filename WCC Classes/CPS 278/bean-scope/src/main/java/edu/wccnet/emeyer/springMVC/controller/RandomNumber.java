package edu.wccnet.emeyer.springMVC.controller;

public class RandomNumber {
	int rand;
	public int getRand() {
		return rand;
	}
	public void generateRandom() {
		rand = (int)(Math.random() * 1000 + 1);
	}

}
