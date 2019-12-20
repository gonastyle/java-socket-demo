package com.mei.rcp.model;

/**
 * @Description:
 * @Author: Administrator
 * @Date: 2019/12/20 13:47
 * @Version: V1.0
 **/
public class HelloImpl implements com.mei.rcp.server.IHello {
    @Override
    public String sayHello(String message) {
        return "HELLO" + message;
    }
}
