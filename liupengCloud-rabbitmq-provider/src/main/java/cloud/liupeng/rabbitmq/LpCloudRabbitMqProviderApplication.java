package cloud.liupeng.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * RabbitMQ提供者,发送消息
 *
 * @author liupeng
 */
@SpringBootApplication
public class LpCloudRabbitMqProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(LpCloudRabbitMqProviderApplication.class, args);
    }
}
