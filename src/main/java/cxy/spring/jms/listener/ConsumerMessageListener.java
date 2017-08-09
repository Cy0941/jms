package cxy.spring.jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Function: MessageListener - 最原始的消息监听器，是JMS规范中定义的一个接口  --  只能用来接收消息
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/8/8 18:18 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */

public class ConsumerMessageListener implements MessageListener {

    public void onMessage(Message message) {
        TextMessage text = (TextMessage)message;
        try {
            System.err.println("ConsumerMessageListener 消息内容是："+text.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
