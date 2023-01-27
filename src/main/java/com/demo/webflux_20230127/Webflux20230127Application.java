package com.demo.webflux_20230127;

import com.demo.webflux_20230127.config.GreetingClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Webflux20230127Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(Webflux20230127Application.class, args);

		GreetingClient greetingClient = context.getBean(GreetingClient.class);

		System.out.println(">> message = " + greetingClient.getMessage().block());
	}

}
