package edu.wccnet.emeyer.DIDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DIDemoApp 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("DIDemoJavaConfig.class");
        College college = (College)context.getBean("wcc");
        
        System.out.println(college);
        college.printCollegeService();
        
        Finaid finaid = (Finaid)context.getBean("finaid");
        finaid.displayFinaid();
        
       context.close();
    }
}
