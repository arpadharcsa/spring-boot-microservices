import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by aharcsa on 2016. 05. 16..
 */

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = Application.BASE_PACKAGE)
public class Application {
    public static final String BASE_PACKAGE = "com.mobilefirstsolutions.microservices.transactionhistory";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
