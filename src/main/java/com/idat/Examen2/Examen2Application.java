package com.idat.Examen2;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Configurable
@EnableAutoConfiguration
public class Examen2Application {

	public static void main(String[] args) {
		SpringApplication.run(Examen2Application.class, args);
	}

}
