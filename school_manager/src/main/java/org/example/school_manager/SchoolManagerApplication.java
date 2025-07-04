package org.example.school_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SchoolManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolManagerApplication.class, args);
    }

}
