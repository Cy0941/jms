package cxy.spring.jms.converter;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import java.io.Serializable;

/**
 * Function: 自定义消息转换器
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/8/9 18:54 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class EmailMessageConverter implements MessageConverter {
    /**
     * 发送
     * @param object
     * @param session
     * @return
     * @throws JMSException
     * @throws MessageConversionException
     */
    public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
        return session.createObjectMessage((Serializable)object);
    }

    /**
     * 消息处理获取
     * @param message
     * @return
     * @throws JMSException
     * @throws MessageConversionException
     */
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        ObjectMessage objectMessage = (ObjectMessage) message;
        return objectMessage.getObject();
    }
}
