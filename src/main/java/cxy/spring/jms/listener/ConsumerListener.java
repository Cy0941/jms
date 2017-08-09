package cxy.spring.jms.listener;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/8/9 17:20 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class ConsumerListener {

    public void handleMessage(String message) {
        System.out.println("ConsumerListener通过 handleMessage 接收到一个纯文本消息，消息内容是：" + message);
    }

    public void receiveMessage(String message) {
        System.out.println("ConsumerListener通过 receiveMessage 接收到一个纯文本消息，消息内容是：" + message);
    }

    /**
     * 当消息处理器的方法返回值不为空 & 不为 null & 不为 void 的时候，Spring会自动将其封装为一个JMSMessage，然后进行自动回复
     *
     * @param message
     */
    public String receiveAndAutoResp(String message) {
        System.out.println("ConsumerListener通过receiveMessage接收到一个纯文本消息，消息内容是：" + message);
        return "这是ConsumerListener对象的 receiveAndAutoResp 方法的返回值。";
    }

}
