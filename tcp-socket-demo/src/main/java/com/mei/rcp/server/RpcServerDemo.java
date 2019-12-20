package com.mei.rcp.server;

import com.mei.rcp.model.HelloImpl;

/**
 * @Description:
 * @Author: Administrator
 * @Date: 2019/12/20 13:53
 * @Version: V1.0
 **/
public class RpcServerDemo {
    public static void main(String[] args) {
        com.mei.rcp.server.IHello hello=new HelloImpl();
        RpcServer rpcServer=new RpcServer();
        //发布服务
        rpcServer.publisher(hello,8080);
    }
}
