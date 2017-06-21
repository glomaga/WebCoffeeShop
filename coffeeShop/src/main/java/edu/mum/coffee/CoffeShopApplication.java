package edu.mum.coffee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.mum.coffee.domain.Orderline;
import edu.mum.coffee.domain.Person;

@SpringBootApplication
public class CoffeShopApplication {

	private static final Logger log = LoggerFactory.getLogger(CoffeShopApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CoffeShopApplication.class, args);	
	}
	
}