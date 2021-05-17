package com.ljg.msacatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsacatalogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsacatalogApplication.class, args);
    }

}
