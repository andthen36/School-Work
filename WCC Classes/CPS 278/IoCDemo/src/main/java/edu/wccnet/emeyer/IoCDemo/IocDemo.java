package edu.wccnet.emeyer.IoCDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IocDemo {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("beanConfig");
		IBrid bird = (IBrid)context.getBean("bird");
		System.out.println(bird.getEatingHabit());
	}
}
