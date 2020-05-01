package cloud.liupeng.activemq.provider.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Topic;
import java.util.UUID;

/**
 * topic消息生产者
 *
 * @author liupeng
 */
@Component
public class TopicProduce {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Topic topic;

    public void provider_send_message() {
        jmsMessagingTemplate.convertAndSend(topic, UUID.randomUUID().toString().substring(0, 12));
    }

    /**
     * 定时发送消息
     */
    @Scheduled(fixedDelay = 5000)
    public void provider_send_message_scheduled() {
        jmsMessagingTemplate.convertAndSend(topic, UUID.randomUUID().toString().substring(0, 12));
    }
}
