package cloud.liupeng.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * RabbitMQ消费者,接收消息
 *
 * @author liupeng
 */
@SpringBootApplication
public class LpCloudRabbitMqConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LpCloudRabbitMqConsumerApplication.class, args);
    }
}
