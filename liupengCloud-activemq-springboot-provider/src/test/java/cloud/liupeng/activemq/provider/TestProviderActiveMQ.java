package cloud.liupeng.activemq.provider;

import cloud.liupeng.activemq.LpCloudActiveMqProviderApplication;
import cloud.liupeng.activemq.provider.queue.QueueProduce;
import cloud.liupeng.activemq.provider.topic.TopicProduce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * ActiveMQ消息生产者测试
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LpCloudActiveMqProviderApplication.class)
public class TestProviderActiveMQ {

    @Autowired
    private QueueProduce queueProduce;

    @Autowired
    private TopicProduce topicProduce;

    /**
     * queue
     */
    @Test
    public void queue_send(){
        queueProduce.provider_send_message();
    }

    /**
     * topic
     */
    @Test
    public void topic_send(){
        topicProduce.provider_send_message();
    }
}
