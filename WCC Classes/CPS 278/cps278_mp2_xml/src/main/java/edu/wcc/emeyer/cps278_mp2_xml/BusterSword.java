package edu.wcc.emeyer.cps278_mp2_xml;

import org.springframework.stereotype.Component;

@Component
public class BusterSword implements FightingPower {

	@Override
	public String getFightingPowerDesc() {
		// TODO Auto-generated method stub
		return "uses his Buster Sword!";
	}

}
