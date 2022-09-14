package com.api.pcj18sb273;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@SpringBootApplication
@RestController
public class PcJ18Sb273Application {

	public static void main(String[] args) {
		SpringApplication.run(PcJ18Sb273Application.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("senha123"));
	}
}
