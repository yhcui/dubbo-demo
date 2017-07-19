package com.yhcui.dubbo;

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
 * @Date Created in 2017年07月19日 10:42
 * @since 1.0
 */
public class Provider {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext  appCon = new ClassPathXmlApplicationContext("META-INF/spring/provider.xml");
        appCon.start();

        appCon.getBean("demoService");
        System.out.println("provider start success------");
        System.in.read();
    }

}
