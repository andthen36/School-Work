package edu.wcc.emeyer.cps278_mp2_xml;

import org.springframework.stereotype.Component;

@Component
public class Fireball implements FightingPower {

	@Override
	public String getFightingPowerDesc() {
		// TODO Auto-generated method stub
		return "throws fireball!";
	}

}
