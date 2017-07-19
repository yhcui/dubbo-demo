package com.yhcui.dubbo;

import com.alibaba.dubbo.rpc.RpcContext;

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
 * @Date Created in 2017年07月19日 12:14
 * @since 1.0
 */
public class BaseServiceImpl implements BaseService {

    public String invokeBase() {

        String serverIP = RpcContext.getContext().getRemoteHost();
        String requestId = (String)RpcContext.getContext().getAttachment("requestId");
        String requestIdTime = (String)RpcContext.getContext().getAttachment("requestIdTime");

        System.out.println("BaseService isConsumer:" + serverIP + ",requestId:" + requestId + ",requestIdTime:" +requestIdTime);
        return "base";
    }
}
