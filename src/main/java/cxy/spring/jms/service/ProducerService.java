package cxy.spring.jms.service;


import javax.jms.Destination;
import java.io.Serializable;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/8/8 11:27 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public interface ProducerService {

    /**
     * 简单String消息发送
     * @param destination
     * @param message
     */
    void sendMessage(Destination destination, final String message);

    /**
     * 发送序列化对象
     * @param destination
     * @param obj
     */
    void sendSerializeObj(Destination destination, final Serializable obj);

}
