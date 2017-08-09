package cxy.spring.jms.listener;

import cxy.spring.jms.model.Email;
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
 * Date: 2017/8/9 17:39 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ConsumerListenerTest {

    @Autowired
    private ProducerService producerService;
    @Autowired
    @Qualifier("adapterQueue")
    private Destination destination;

    @Test
    public void onMessage() throws Exception {
        producerService.sendMessage(destination, "测试 自定义回复地址 。。。");
    }

    @Test
    public void sendEmail() throws Exception {
        Email email = new Email("zhangsan@xxx.com","主题","内容");
        producerService.sendSerializeObj(destination,email);
    }
}