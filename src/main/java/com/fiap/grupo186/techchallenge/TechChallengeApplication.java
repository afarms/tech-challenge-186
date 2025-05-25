package com.fiap.grupo186.techchallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//TODO: When we hava a database, we can remove the exclude annotation! [IMPORTANT!]
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@SpringBootApplication
public class TechChallengeApplication {
    public static void main(String[] args) {
        SpringApplication.run(TechChallengeApplication.class, args);
    }

}
