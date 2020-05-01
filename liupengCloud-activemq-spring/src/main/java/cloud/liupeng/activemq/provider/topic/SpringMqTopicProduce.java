package cloud.liupeng.activemq.provider.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * Topic生产者 - 先启动消费者，在启动生产者
 *
 * @author liupeng
 */
@Service
public class SpringMqTopicProduce {

    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextTopic.xml");
        SpringMqTopicProduce springMqQuerueProduce = (SpringMqTopicProduce) applicationContext.getBean("springMqTopicProduce");
        springMqQuerueProduce.jmsTemplate.send(session -> {
            return session.createTextMessage("spring整合ActiveMQ");
        });
        System.out.println("ActiveMQ生产消息结束！");
    }
}
