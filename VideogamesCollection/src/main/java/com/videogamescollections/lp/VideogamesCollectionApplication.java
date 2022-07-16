package com.videogamescollections.lp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.videogamescollections.lp.*" })
public class VideogamesCollectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideogamesCollectionApplication.class, args);
	}

}
