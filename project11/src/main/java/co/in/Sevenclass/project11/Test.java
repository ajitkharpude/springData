package co.in.Sevenclass.project11;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ApplicationContext applicationContext=new ClassPathXmlApplicationContext("configration.xml");
Student sd= applicationContext.getBean(Student.class);
System.out.println(sd);

	}

}
