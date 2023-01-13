package com.troy.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
/*public class LibApi1Application {

	public static void main(String[] args) {
		SpringApplication.run(LibApi1Application.class, args);
	}

}*/

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibApi1Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(LibApi1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("this is testing");
    }
}

