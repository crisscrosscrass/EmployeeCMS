package com.crisscrosscrass.EmployeeCMS;

import com.crisscrosscrass.EmployeeCMS.controller.IndexController;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EmployeeCmsApplication {
	final static Logger logger = Logger.getLogger(String.valueOf(EmployeeCmsApplication.class));
	public static void main(String[] args) {
		SpringApplication.run(EmployeeCmsApplication.class, args);
	}
}
