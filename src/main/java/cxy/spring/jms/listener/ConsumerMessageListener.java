package cxy.spring.jms.listener;

import cxy.spring.jms.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.*;
import javax.xml.soap.Text;

/**
 * Function: MessageListener - 最原始的消息监听器，是JMS规范中定义的一个接口  --  只能用来接收消息
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/8/8 18:18 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */

public class ConsumerMessageListener implements MessageListener {

    @Autowired
    private MessageConverter messageConverter;

    public void onMessage(Message message) {
        if (message instanceof Text) {
            TextMessage text = (TextMessage) message;
            try {
                System.err.println("ConsumerMessageListener 消息内容是：" + text.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        } else if (message instanceof ObjectMessage) {
            ObjectMessage objectMessage = (ObjectMessage) message;
            try {
                //Email email = (Email) objectMessage.getObject();
                //使用自定义消息转换器
                Email email = (Email) messageConverter.fromMessage(objectMessage);
                System.err.println("ConsumerMessageListener 消息内容是：" + email);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
