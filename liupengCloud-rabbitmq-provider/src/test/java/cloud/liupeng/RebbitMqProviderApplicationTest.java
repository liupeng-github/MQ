package cloud.liupeng;

import cloud.liupeng.rabbitmq.LpCloudRabbitMqProviderApplication;
import cloud.liupeng.rabbitmq.direct.ErrorSender;
import cloud.liupeng.rabbitmq.direct.InfoSender;
import cloud.liupeng.rabbitmq.direct.OrderSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LpCloudRabbitMqProviderApplication.class)
public class RebbitMqProviderApplicationTest {

    @Autowired
    private OrderSender orderSender;
    @Autowired
    private InfoSender infoSender;
    @Autowired
    private ErrorSender errorSender;

    /**
     * 发送订单消息
     */
    @Test
    public void orderSender_Test() {

        System.out.println("客户下单后调用此方法，消息发送给商家处理");
        orderSender.send("某某某用户您好：您有一条订单信息，请及时处理！");
    }

    /**
     * 测试info消息
     *
     * @throws InterruptedException
     */
    @Test
    public void infoSender_Test() throws InterruptedException {

        System.out.println("处理消息，发送消息！");
        /*while (true) {
            Thread.sleep(1000);
            infoSender.send("您有一条新的消息，请注意查收！");
        }*/
        /*for (int i = 0; i < 100; i++) {
            Thread.sleep(1000);
            infoSender.send("您有一条新的消息，请注意查收！");
        }*/
    }

    /**
     * 测试error消息
     *
     * @throws InterruptedException
     */
    @Test
    public void errorSender_Test() throws InterruptedException {

        System.out.println("处理消息，发送消息！");
        /*while (true) {
            Thread.sleep(1000);
            errorSender.send("您有一条新的消息，请注意查收！");
        }*/
    }
}
