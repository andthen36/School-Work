package edu.wccnet.emeyer.IoCDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IocDemo2 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beanConfig2.xml");
		IBrid bird = (IBrid)context.getBean("bird");
		System.out.println(bird.getEatingHabit());
		((ClassPathXmlApplicationContext)context).close();
	}
}
