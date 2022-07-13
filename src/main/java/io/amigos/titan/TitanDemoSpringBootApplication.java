package io.amigos.titan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TitanDemoSpringBootApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(TitanDemoSpringBootApplication.class, args);

    }
}
