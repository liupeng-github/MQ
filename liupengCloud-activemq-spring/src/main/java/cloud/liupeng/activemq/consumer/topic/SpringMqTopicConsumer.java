package cloud.liupeng.activemq.consumer.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * Topic消费者 - 先启动消费者，在启动生产者
 *
 * @author liupeng
 */
@Service
public class SpringMqTopicConsumer {

    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextTopic.xml");
        SpringMqTopicConsumer springMqQueueConsumer = (SpringMqTopicConsumer) applicationContext.getBean("springMqTopicConsumer");
        String receiveAndConvert = (String) springMqQueueConsumer.jmsTemplate.receiveAndConvert();
        System.out.println("消费者收到消息：" + receiveAndConvert);
    }
}
