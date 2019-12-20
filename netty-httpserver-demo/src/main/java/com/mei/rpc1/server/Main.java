package com.mei.rpc1.server;

/**
 * @Description:
 * @Author: Administrator
 * @Date: 2019/12/20 10:14
 * @Version: V1.0
 **/
public class Main {
    public static void main(String[] args) throws Exception {
        //启动server服务
        new NettyServer().bind(8080);
    }

}
