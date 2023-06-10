package com.example.pfa;

import com.example.pfa.entities.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class PfaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PfaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
/*
	private void createUser(){
		for (int i = 1; i < 10; i++) {
			User user=new User();

		}
	}*/

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
