package cxy.spring.jms.service.impl;

import cxy.spring.jms.service.ProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Destination;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/8/8 18:44 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ProducerServiceImplTest {

    @Autowired
    private ProducerService producerService;
    @Autowired
    @Qualifier("activeMQQueue")
    private Destination destination;

    @Test
    public void sendMessage() throws Exception {
        for (int i = 0; i < 2; i++) {
            producerService.sendMessage(destination, "您好，生产者！这是消息：" + (i + 1));
        }
    }

}