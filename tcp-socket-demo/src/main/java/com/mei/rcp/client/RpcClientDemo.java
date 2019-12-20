package com.mei.rcp.client;

import com.mei.rcp.server.IHello;

/**
 * @Description:
 * @Author: Administrator
 * @Date: 2019/12/20 13:56
 * @Version: V1.0
 **/
public class RpcClientDemo {
    public static void main(String[] args) {
        RpcClientProxy proxy = new RpcClientProxy();
        IHello iHello = proxy.clientProxy(IHello.class, "localhost", 8080);
        System.out.println(iHello.sayHello("xxxx"));
    }

}
