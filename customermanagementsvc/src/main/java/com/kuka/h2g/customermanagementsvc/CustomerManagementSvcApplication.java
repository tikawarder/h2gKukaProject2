package com.kuka.h2g.customermanagementsvc;

import com.kuka.h2g.customermanagementsvc.config.Configuration;
import com.kuka.h2g.customermanagementsvc.controller.CustomerController;
import com.kuka.h2g.customermanagementsvc.service.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class CustomerManagementSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerManagementSvcApplication.class, args);
	}

}
