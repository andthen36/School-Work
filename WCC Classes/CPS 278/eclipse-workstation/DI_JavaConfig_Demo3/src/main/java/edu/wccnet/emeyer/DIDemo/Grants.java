package edu.wccnet.emeyer.DIDemo;

import org.springframework.stereotype.Component;

@Component
public class Grants implements FinaidService {

	@Override
	public String getFinaidType() {
		// TODO Auto-generated method stub
		return "Grants";
	}

}
