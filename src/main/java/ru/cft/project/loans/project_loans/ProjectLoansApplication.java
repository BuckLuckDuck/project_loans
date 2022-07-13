package ru.cft.project.loans.project_loans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ProjectLoansApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectLoansApplication.class, args);
    }

}
