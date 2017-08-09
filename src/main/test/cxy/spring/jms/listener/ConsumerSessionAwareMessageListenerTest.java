package cxy.spring.jms.listener;

import cxy.spring.jms.service.ProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Destination;

import static org.junit.Assert.*;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/8/8 19:36 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ConsumerSessionAwareMessageListenerTest {

    @Autowired
    private ProducerService producerService;
    @Autowired
    @Qualifier("sessionAwareQueue")
    private Destination destination;

    @Test
    public void onMessage() throws Exception {
        producerService.sendMessage(destination, "测试 ConsumerSessionAwareMessageListener 。。。");
    }

}