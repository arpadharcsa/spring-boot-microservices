import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by aharcsa on 2016. 05. 05..
 */

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = Application.BASE_PACKAGE)
public class Application {

    public static final String BASE_PACKAGE = "com.mobilefirstsolutions.microservices.gateway";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
