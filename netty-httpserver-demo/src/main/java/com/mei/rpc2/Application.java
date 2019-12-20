package com.mei.rpc2;

/**
 * @Description:
 * @Author: Administrator
 * @Date: 2019/12/20 13:35
 * @Version: V1.0
 **/
public class Application {
    public static void main(String[] args) throws Exception {

        /**
         * http://localhost:8081/index
         */
        HttpServer server = new HttpServer(8081);// 8081为启动端口
        server.start();
    }
}
