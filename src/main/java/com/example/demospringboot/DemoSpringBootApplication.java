package com.example.demospringboot;

import com.example.demospringboot.model.Customer;
import com.example.demospringboot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.management.MXBean;

@SpringBootApplication
public class DemoSpringBootApplication {

    @Autowired
    private CustomerRepository custRepo;
	public static void main(String[] args) {
	    SpringApplication.run(DemoSpringBootApplication.class, args);
	}

	@Bean
    public CommandLineRunner insertRecords() {
	    return (args) -> {
	        custRepo.save(new Customer("Rosheni" , "Kosanam"));
            custRepo.save(new Customer("Joe" , "Wills"));
            custRepo.save(new Customer("Robert" , "Jr"));
            custRepo.save(new Customer("Mia" , "Jones"));
        };
    }
}
