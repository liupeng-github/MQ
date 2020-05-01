package cloud.liupeng.activemq.provider.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.UUID;

/**
 * queue消息生产者
 *
 * @author liupeng
 */
@Component
public class QueueProduce {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    public void provider_send_message() {
        jmsMessagingTemplate.convertAndSend(queue, UUID.randomUUID().toString().substring(0, 12));
    }

    /**
     * 定时发送消息
     */
    @Scheduled(fixedDelay = 5000)
    public void provider_send_message_scheduled() {
        jmsMessagingTemplate.convertAndSend(queue, UUID.randomUUID().toString().substring(0, 12));
    }
}
