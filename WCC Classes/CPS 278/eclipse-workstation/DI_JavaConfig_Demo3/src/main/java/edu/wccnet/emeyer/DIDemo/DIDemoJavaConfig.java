package edu.wccnet.emeyer.DIDemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("edu.wccnet.emeyer.DIDemo")
@PropertySource("classpath:collegeProperties")
public class DIDemoJavaConfig {
	
}
