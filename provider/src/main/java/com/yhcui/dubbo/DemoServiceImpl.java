package com.yhcui.dubbo;

import com.alibaba.dubbo.rpc.RpcContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
// *
 * @author cuiyuhui
 * @version 1.0
 * @Date Created in 2017年07月19日 10:31
 * @since 1.0
 */
public class DemoServiceImpl implements  DemoService {


    private BaseService baseService;

    public String sayHello() {
        boolean isConsumer = RpcContext.getContext().isConsumerSide();
        String serverIP = RpcContext.getContext().getRemoteHost();
        String requestId = (String)RpcContext.getContext().getAttachment("requestId");
        String requestIdTime = (String)RpcContext.getContext().getAttachment("requestIdTime");

        System.out.println("DemoService isConsumer:" + isConsumer + ",:" + serverIP + ",requestId:" + requestId + ",requestIdTime:" +requestIdTime);
        System.out.println("service:" + baseService);

        RpcContext.getContext().setAttachment("requestId", "222");

        String result = baseService.invokeBase();
//        String result = "";
        System.out.println("invokeBase" + result);
        System.out.println("Hello World!");
        return "Hello World";
    }

    public BaseService getBaseService() {
        return baseService;
    }

    public void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }
}
