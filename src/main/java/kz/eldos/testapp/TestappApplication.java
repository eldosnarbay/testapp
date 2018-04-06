package kz.eldos.testapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class TestappApplication {

	public static void main(String[] args) {
        SpringApplication application = new SpringApplication(TestappApplication.class);
        Map<String, Object> props = new HashMap<>();
        props.put("server.port", 8085);
        application.setDefaultProperties(props);
		application.run(args);
	}
}
