package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JDBCTemplateExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		EmployeeDao employeeDao = (EmployeeDao)context.getBean("edao");
		int status = employeeDao.saveEmployee(new Employee(1,"Andrew", 10000));
		System.out.println(status);
	}

}
