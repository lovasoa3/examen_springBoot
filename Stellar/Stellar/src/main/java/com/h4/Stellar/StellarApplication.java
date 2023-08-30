package com.h4.Stellar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.h4.Stellar","controleur", "model","repository","service"})
public class StellarApplication {
	public static void main(String[] args) {
		SpringApplication.run(StellarApplication.class, args);
	}

}
