package ar.edu.undef.fie.criptoboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CriptoBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CriptoBootApplication.class, args);
	}

}
