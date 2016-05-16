import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by aharcsa on 2016. 05. 04..
 */

@SpringBootApplication
@EnableEurekaServer
@ComponentScan(useDefaultFilters = false)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
