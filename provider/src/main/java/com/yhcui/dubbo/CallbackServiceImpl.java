package com.yhcui.dubbo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
 * @Date Created in 2017年07月19日 14:52
 * @since 1.0
 */
public class CallbackServiceImpl implements  CallbackService {


    private final Map<String, CallbackListener> chm = new ConcurrentHashMap<String, CallbackListener>();

    public CallbackServiceImpl() {
        Thread t = new Thread(){
            @Override
            public void run() {
                int i = 0;

                while (true) {
                    if (i == 10) {
                        return ;
                    }
                    for (Map.Entry<String, CallbackListener> entry : chm.entrySet()) {
                        entry.getValue().change("flag:" + i + ",:" + getChanged(entry.getKey()));
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
    }

    public void addListener(String key, CallbackListener listener) {
        chm.put(key,listener);

    }
    private String getChanged(String key) {
        return "Changed: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
