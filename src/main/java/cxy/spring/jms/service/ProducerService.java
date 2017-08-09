package cxy.spring.jms.service;


import javax.jms.Destination;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/8/8 11:27 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public interface ProducerService {

    void sendMessage(Destination destination, final String message);

}
