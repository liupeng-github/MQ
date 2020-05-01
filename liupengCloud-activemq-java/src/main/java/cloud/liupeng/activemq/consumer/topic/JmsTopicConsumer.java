package cloud.liupeng.activemq.consumer.topic;

import cloud.liupeng.activemq.ActiveMqCommons;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * topic消息消费者 - 先启动消费者后启动生产者
 *
 * @author liupeng
 */
public class JmsTopicConsumer extends ActiveMqCommons {

    public static void main(String[] args) throws JMSException {
        Connection connection = null;
        Session session = null;
        MessageConsumer messageConsumer = null;

        try {
            //1、创建连接工厂，按照给定的url地址，采用默认的用户名和密码
            ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, ACTIVE_MQ);
            //2、通过连接工厂，获得连接connection并启动访问
            connection = activeMQConnectionFactory.createConnection();
            connection.start();
            //3、创建会话session，参数一：事务，参数二：签收
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //4、创建目的地（具体是队列还是主题Topic）
            Topic topic = session.createTopic(TOPIC_NAME);
            //5、创建消息消费者
            messageConsumer = session.createConsumer(topic);
            messageConsumer.setMessageListener(message -> {
                if (message != null && message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println("topic消费者收到消息：" + textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //9、关闭资源
            messageConsumer.close();
            session.close();
            connection.close();
        }
    }
}
