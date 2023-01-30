package edu.wcc.emeyer.cps278_mp2_xml;

import org.springframework.context.annotation.Bean;

public class JavaBeanConfig {

    @Bean
	public Character character1() {
		Character character = new Character();
		character.setName("Cloud");
		character.setFightingPower(busterSword());
		return character;
	}
    @Bean
    public Character character2() {
        Character character = new Character();
        character.setName("Steve from Minecraft");
        character.setFightingPower(fireBall());
        return character;
    }
    @Bean
    public Fireball fireBall(){
        return new Fireball();
    }

    @Bean
    public BusterSword busterSword(){
        return new BusterSword();
    }

    @Bean
    public BattleGround battleGround(){
        return new Midgar();
    }
    @Bean
    public Battle battle(){
        Battle battle = new Battle();
        battle.setBattleGround(battleGround());
        battle.setCharacter1(character1());
        battle.setCharacter2(character2());
        return battle;
    }

}
