package edu.wccnet.emeyer.DIDemo;

import org.springframework.stereotype.Component;


public class CommunityCollegeService implements CollegeService {

	
	public String getService(String collegeName) {
		// TODO Auto-generated method stub
		return collegeName + " is a 2 year community college.";
	}

}
