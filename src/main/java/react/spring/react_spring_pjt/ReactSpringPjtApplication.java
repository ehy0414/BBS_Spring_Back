package react.spring.react_spring_pjt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ReactSpringPjtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactSpringPjtApplication.class, args);
	}

}
