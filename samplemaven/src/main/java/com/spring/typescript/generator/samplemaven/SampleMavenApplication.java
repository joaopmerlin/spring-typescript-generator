package com.spring.typescript.generator.samplemaven;

import com.spring.typescript.generator.annotation.EnableSpringTypescriptGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by joao on 17/08/17.
 */

@SpringBootApplication
@EnableSpringTypescriptGenerator
public class SampleMavenApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleMavenApplication.class, args);
    }
}
