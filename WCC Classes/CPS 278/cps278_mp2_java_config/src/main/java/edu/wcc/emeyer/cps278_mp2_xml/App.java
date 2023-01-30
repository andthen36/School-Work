package edu.wcc.emeyer.cps278_mp2_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {

    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaBeanConfig.class);
        Battle b = (Battle)context.getBean("battle");
        b.fight();
        context.close();
    }
}
