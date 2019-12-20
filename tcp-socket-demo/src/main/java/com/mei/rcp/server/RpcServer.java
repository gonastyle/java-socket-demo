package com.mei.rcp.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: Administrator
 * @Date: 2019/12/20 13:52
 * @Version: V1.0
 **/
public class RpcServer {
    //创建一个线程池
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    public void publisher(final Object service, int port) {
        //创建一个服务端socket，且设置传送过来的端口
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("服务端启动成功...");
            //循环监听
            while (true) {
                Socket socket = serverSocket.accept();
                //把监听到的请求交给线程池去处理
                EXECUTOR_SERVICE.execute(new ProcessorHandler(service, socket));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
