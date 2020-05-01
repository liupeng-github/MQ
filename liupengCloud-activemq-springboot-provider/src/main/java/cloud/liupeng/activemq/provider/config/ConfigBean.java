package cloud.liupeng.activemq.provider.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * 生产者配置类
 *
 * @author liupeng
 */
@EnableJms
@Component
public class ConfigBean {

    @Value("${queueName}")
    private String queueName;

    @Value("${topicName}")
    private String topicName;

    @Bean
    public Queue queue() {
        return new ActiveMQQueue(queueName);
    }
    @Bean
    public Topic topic() {
        return new ActiveMQTopic(topicName);
    }

}
