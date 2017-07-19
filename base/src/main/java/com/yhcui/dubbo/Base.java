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
 * @Date Created in 2017年07月19日 12:25
 * @since 1.0
 */
public class Base {
    /**
     *
     * @author cuiyuhui
     * @created
     * @param
     * @return
     */
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/base.xml");
        applicationContext.start();
        try {
            System.out.println("base provider start success------------");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
