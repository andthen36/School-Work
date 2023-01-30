package edu.wccnet.emeyer.json_demo;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class App 
{
    public static void main( String[] args )
    {
       ObjectMapper mapper = new ObjectMapper();
       try {
		Student student = mapper.readValue(new File("data/student.json"), Student.class);
		 System.out.println(student);
		 for (String eachCourse: student.getCourseList()) {
		 System.out.println(eachCourse);
		 }
		 mapper.enable(SerializationFeature.INDENT_OUTPUT);
		 mapper.writeValue(new File("data/newStudent.json"), student);
		 System.out.println(mapper.writeValueAsString(student));
	} catch (StreamReadException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (DatabindException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
    }
}
