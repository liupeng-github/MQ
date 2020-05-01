package cloud.liupeng.activemq.consumer.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * Queue消费者
 *
 * @author liupeng
 */
@Service
public class SpringMqQueueConsumer {

    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextQueue.xml");
        SpringMqQueueConsumer springMqQueueConsumer = (SpringMqQueueConsumer) applicationContext.getBean("springMqQueueConsumer");
        String receiveAndConvert = (String) springMqQueueConsumer.jmsTemplate.receiveAndConvert();
        System.out.println("消费者收到消息：" + receiveAndConvert);
    }
}
