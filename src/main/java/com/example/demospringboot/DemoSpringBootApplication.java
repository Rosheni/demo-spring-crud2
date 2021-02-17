package com.example.demospringboot;

import com.example.demospringboot.model.Customer;
import com.example.demospringboot.model.Student;
import com.example.demospringboot.repository.CustomerRepository;
import com.example.demospringboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoSpringBootApplication {

    @Autowired
    private CustomerRepository custRepo;
    private StudentRepository studRepo;

    public DemoSpringBootApplication(StudentRepository studRepo) {
        this.studRepo = studRepo;
    }

    public static void main(String[] args) {
	    SpringApplication.run(DemoSpringBootApplication.class, args);
	}

	@Bean
    public CommandLineRunner insertRecords() {
	    return (args) -> {

//	customer records
	        custRepo.save(new Customer("Rosheni" , "Kosanam"));
            custRepo.save(new Customer("Joe" , "Wills"));
            custRepo.save(new Customer("Robert" , "Jr"));
            custRepo.save(new Customer("Mia" , "Jones"));

//  student records

            studRepo.save(new Student ("Rosheni" , "Java" , "kosanamrosheni@gmail.com"));
            studRepo.save(new Student ("Jasmin" , "Angular" ,"jasminflos@gmail.com"));
            studRepo.save(new Student ("Bill" , "C","billgates@gmail.com"));
            studRepo.save(new Student ("Riya" , "Python","riyamalhotra@gmail.com"));

        };


    }
}

