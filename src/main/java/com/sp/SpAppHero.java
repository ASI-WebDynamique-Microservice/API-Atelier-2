package com.sp;

import com.sp.Service.GenerateService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpAppHero {

	@Autowired
	private GenerateService generateService;

	public static void main(String[] args) {
		SpringApplication.run(SpAppHero.class, args);
	}

	@PostConstruct
	public void init() {
		generateService.createAndSaveInitialCards();
	}
}
