package lk.dialog.eventdriven.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class OrderServiceApplication{


    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

}
