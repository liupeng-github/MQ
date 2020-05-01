package cloud.liupeng.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author liupeng
 */
@EnableScheduling
@SpringBootApplication
public class LpCloudActiveMqProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(LpCloudActiveMqProviderApplication.class, args);
    }
}
