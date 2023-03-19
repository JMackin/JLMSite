package com.JLMSite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
@EntityScan
public class JlmSiteApplication {

	public static void main(String[] args) {
		try (ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(JlmSiteApplication.class, args)) {
		}catch (Exception e)
		{
			System.out.printf(String.valueOf(e.getCause()));
		}


	}

}
