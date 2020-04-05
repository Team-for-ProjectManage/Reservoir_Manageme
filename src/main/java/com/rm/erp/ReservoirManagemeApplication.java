package com.rm.erp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages = {"com.rm.erp.datasource.mappers"})
@ServletComponentScan
@EnableScheduling
public class ReservoirManagemeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservoirManagemeApplication.class, args);
	}

}
