package cloud.liupeng.activemq.provider.queue;

import cloud.liupeng.activemq.ActiveMqCommons;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * queue消息生产者
 *
 * @author liupeng
 */
public class JmsQueueProduce extends ActiveMqCommons {

    public static void main(String[] args) throws JMSException {

        Connection connection = null;
        Session session = null;
        MessageProducer messageProducer = null;

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
            //5、创建消息生产者
            messageProducer = session.createProducer(queue);
            //6、使用messageProducer生产5条消息发送到MQ的队列里面
            for (int i = 0; i < 5; i++) {
                //7、创建消息
                TextMessage textMessage = session.createTextMessage("生产者发送第" + i + "条消息!");
                //8、通过messageProducer发送消息到MQ
                messageProducer.send(textMessage);
            }
            System.out.println("Queue消息发送到MQ系统");
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            //9、关闭资源
            messageProducer.close();
            session.close();
            connection.close();
        }
    }
}
