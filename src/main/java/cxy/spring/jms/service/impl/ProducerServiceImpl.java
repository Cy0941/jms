package cxy.spring.jms.service.impl;

import cxy.spring.jms.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.*;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/8/8 11:34 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier("responseQueue")
    private Destination responseDestination;

    public void sendMessage(Destination destination, final String message) {
        System.out.println("---------------生产者发了一个消息：" + message);
        //cxy MessageListenerAdapter 指定自动回复地址一  --  defaultResponseDestination 属性
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });

        //cxy MessageListenerAdapter 指定自动回复地址一  --  setJMSReplyTo 方法  && 优先级更高
        //jmsTemplate.send(destination, new MessageCreator() {
        //    public Message createMessage(Session session) throws JMSException {
        //        TextMessage textMessage = session.createTextMessage(message);
        //        //当使用 MessageListenerAdapter 可以实现自动消息回复时 -- 设置回复地址
        //        textMessage.setJMSReplyTo(responseDestination);
        //        return textMessage;
        //    }
        //});
    }
}
