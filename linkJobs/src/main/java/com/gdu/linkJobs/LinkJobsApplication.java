package com.gdu.linkJobs;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


@SpringBootApplication
public class LinkJobsApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(LinkJobsApplication.class, args);
	}

	
	@Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);
        javaMailSender.setUsername("jisunchoi12@gmail.com");
        javaMailSender.setPassword("chlwltjs1234!");
        
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        javaMailSender.setJavaMailProperties(properties);
        
        return javaMailSender;
    }

}
