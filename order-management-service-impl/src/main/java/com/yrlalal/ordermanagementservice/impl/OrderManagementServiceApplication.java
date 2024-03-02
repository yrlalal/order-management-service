package com.yrlalal.ordermanagementservice.impl;

import com.yrlalal.ordermanagementservice.api.v1.OrderManagementServiceApiConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackageClasses = { OrderManagementServiceApplication.class,
		OrderManagementServiceApiConfiguration.class })
@EnableJpaRepositories
@EntityScan(basePackageClasses = OrderManagementServiceApiConfiguration.class)
public class OrderManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderManagementServiceApplication.class, args);
	}

}
