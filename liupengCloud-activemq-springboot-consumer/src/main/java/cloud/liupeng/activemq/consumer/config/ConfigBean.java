package cloud.liupeng.activemq.consumer.config;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * 消费者配置类
 *
 * @author liupeng
 */
@Component
public class ConfigBean {

    @JmsListener(destination = "${queueName}")
    public void receive(TextMessage textMessage) throws JMSException {
        System.out.println("消费者收到消息：" + textMessage.getText());
    }
}
