package cloud.liupeng.activemq.consumer.queue;

import cloud.liupeng.activemq.ActiveMqCommons;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * queue消息消费者
 *
 * @author liupeng
 */
public class JmsQueueConsumer extends ActiveMqCommons {

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
            Queue queue = session.createQueue(QUEUE_NAME);
            //5、创建消息消费者
            messageConsumer = session.createConsumer(queue);
            //同步阻塞方法(receive())：订阅者或者接收则调用messageConsumer的receive()方法来接收消息，
            //receive()方法在能够接收到消息之前(或超时之前)将一直阻塞。
            while (true) {
                TextMessage receive = (TextMessage) messageConsumer.receive();
                if (receive != null) {
                    System.out.println("queue消费者收到消息：" + receive.getText());
                } else {
                    break;
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            //9、关闭资源
            messageConsumer.close();
            session.close();
            connection.close();
        }
    }
}
