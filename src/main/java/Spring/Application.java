package Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Collections;

@SpringBootApplication
public class Application {

    public static void startSpring(String[] args){
        SpringApplication application = new SpringApplication(Application.class);
        application.setDefaultProperties(Collections.singletonMap("server.port", 20000));
        application.run(args);
    }
}