package cxy.spring.jms.listener;

import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.jms.*;

/**
 * Function: SessionAwareMessageListener - Spring 提供  --  接收到消息后可以通知Destination已接收到消息
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/8/8 19:08 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class ConsumerSessionAwareMessageListener implements SessionAwareMessageListener<TextMessage> {

    private Destination destination;

    public void onMessage(TextMessage message, Session session) throws JMSException {
        System.err.println("---------------ConsumerSessionAwareMessageListener 消费者接收了一个消息：" + message.getText());
        MessageProducer producer = session.createProducer(destination);
        TextMessage textMessageFromConsumer = session.createTextMessage("ConsumerSessionAwareMessageListener...");
        producer.send(textMessageFromConsumer);
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}
