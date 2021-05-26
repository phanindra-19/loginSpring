package com.cg.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class LoginApplication implements CommandLineRunner{
	@Autowired
	private PersonService personservice;
	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Person p1=new Person();
		p1.setUsername("Phani");
		p1.setPassword(getPasswordEncoder().encode("123"));
		p1.setRole("ROLE_ADMIN");
		
		Person p2=new Person();
		p2.setUsername("Hari");
		p2.setPassword(getPasswordEncoder().encode("123"));
		p2.setRole("ROLE_USER");
		
		personservice.save(p2);
		personservice.save(p1);
	}
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
