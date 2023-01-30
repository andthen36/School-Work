package edu.wccnet.emeyer.DI_XML_Demo;

public class Finaid {
	private College college;
	private FinaidService finaidService;
	public Finaid(College college, FinaidService finaidService) {
		super();
		this.college = college;
		this.finaidService = finaidService;
	}
	
	public void displayFinaid() {
		System.out.println("You recieved " + finaidService.getFinaidType() 
		+ " from " + college.getCollegeName());
	}

}
