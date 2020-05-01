package cloud.liupeng.rabbitmq.direct;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 消息接收者
 * @RabbitListener注解->bindings：绑定队列
 * @QueueBinding注解->value：绑定队列的名称。
 * 					 exchange：配置交换器。
 * 					 key：配置路由键
 * @Queue注解->value：配置队列名称。
 * 			  autoDelete：是否为一个可删除的临时队列
 * @Exchange注解->value：配置交换器名称。
 * 				 type：指定具体的交换器类型
 * @author liupeng
 *
 */
@Component
@RabbitListener(bindings = @QueueBinding(
		value = @Queue(value = "${rabbitmq.config.queue.info}", autoDelete = "true"),
		exchange = @Exchange(value = "${rabbitmq.config.exchange}", type = ExchangeTypes.DIRECT),
		key = "${rabbitmq.config.queue.info.routing.key}"))
public class InfoReceiver {

	/**
	 * 接收消息的方法，采用消息队列监听机制
	 * @param message
	 */
	@RabbitHandler
	public void process(String message) {
		
		System.out.println("接收处理...info...消息：" + message);
	}
}
