package com.spring;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDao {
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int saveEmployee(Employee e){
		String query = "insert into employee values(" + e.getId()+","+ e.getName() +"," + e.getSalary()+")";
		return this.jdbcTemplate.update(query);
//		return 1;
	}
	
	public int updateEmployee(Employee e){
		String query = "update employee set name = " + e.getName() +", salary = " + e.getSalary() 
				+ "where id = " + e.getId();
		return this.jdbcTemplate.update(query);
	}
}
