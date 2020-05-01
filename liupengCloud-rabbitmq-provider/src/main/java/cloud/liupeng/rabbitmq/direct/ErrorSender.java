package cloud.liupeng.rabbitmq.direct;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 消息发送者
 * @author liupeng
 *
 */
@Component
public class ErrorSender {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	//交换器名称
	@Value("${rabbitmq.config.exchange}")
	private String exchange;
	
	//路由键
	@Value("${rabbitmq.config.queue.error.routing.key}")
	private String routingkey;
	
	/**
	 * 发送消息
	 * convertAndSend参数一：交换器名称。参数二：路由键。参数三：消息。
	 * @param message
	 */
	public void send(String message) {
		
		this.amqpTemplate.convertAndSend(this.exchange, this.routingkey, message);
	}
}
