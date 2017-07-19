package com.yhcui.dubbo;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.EchoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author cuiyuhui
 * @version 1.0
 * @Date Created in 2017年07月19日 11:36
 * @since 1.0
 */
public class Consumer {

    /**
     * 
     * @author cuiyuhui
     * @created
     * @param 
     * @return 
     */
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/consumer.xml");
        applicationContext.start();



        DemoService ds = (DemoService)applicationContext.getBean("demoService");

        EchoService echoService = (EchoService)ds;
        String echoResult = (String) echoService.$echo("OK");
        System.out.println("echoResult:" + echoResult);

        boolean isConsumer = RpcContext.getContext().isConsumerSide();
        System.out.println("isConsumer:" + isConsumer);
        RpcContext.getContext().setAttachment("requestId", "12121");
        RpcContext.getContext().setAttachment("requestIdTime", "1");
        String result = ds.sayHello();

        result = ds.sayHello();
        System.out.println("result:" + result);


        System.out.println("----------我是分隔符----------");

        CallbackService callbackService = (CallbackService)applicationContext.getBean("callbackService");

        callbackService.addListener("i am", new CallbackListener() {
            public void change(String msg) {
                System.out.println("msg:" + msg);
            }
        });



    }

}
