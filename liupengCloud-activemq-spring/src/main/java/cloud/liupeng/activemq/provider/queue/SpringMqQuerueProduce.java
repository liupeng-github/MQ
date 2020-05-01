package cloud.liupeng.activemq.provider.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * Queue生产者
 *
 * @author liupeng
 */
@Service
public class SpringMqQuerueProduce {

    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextQueue.xml");
        SpringMqQuerueProduce springMqQuerueProduce = (SpringMqQuerueProduce) applicationContext.getBean("springMqQuerueProduce");
        springMqQuerueProduce.jmsTemplate.send(session -> {
            return session.createTextMessage("spring整合ActiveMQ");
        });
        System.out.println("ActiveMQ生产消息结束！");
    }
}
