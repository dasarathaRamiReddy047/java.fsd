package com.SpringIntegration;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcSpringIntegrationDemo {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");

        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

        // Create table
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS employees (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100))");

        // Insert data
        jdbcTemplate.update("INSERT INTO employees (name) VALUES (?)", "Sachin");
        jdbcTemplate.update("INSERT INTO employees (name) VALUES (?)", "Virat");


        // Read data
        String name = jdbcTemplate.queryForObject("SELECT name FROM employees WHERE id = ?", new Object[]{2}, String.class);
        System.out.println("Employee name: " + name);

        context.close();
    }
}
