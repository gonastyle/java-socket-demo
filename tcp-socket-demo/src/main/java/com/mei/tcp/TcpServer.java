package com.mei.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: Administrator
 * @Date: 2019/11/23 19:41
 * @Version: V1.0
 **/
public class TcpServer {

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    /**
     * 默认端口
     */
    public int port = 65535;

    public TcpServer(int port) {
        this.port = port;
    }

    public TcpServer() {

    }


    /**
     * 启动服务
     */
    public void start() throws IOException {
        //监听端口
        ServerSocket server = new ServerSocket(port);

        Socket socket = null;
        while (true) {
            //等待连接
            socket = server.accept();
            System.out.println(String.format("%s：客户端建立连接", socket.getInetAddress().getHostAddress()));
            Socket finalSocket = socket;
            Runnable task = () -> {
                InputStream inputStream = null;
                InputStreamReader inputStreamReader = null;
                BufferedReader bufferedReader = null;
                OutputStream outputStream = null;
                OutputStreamWriter writer = null;
                try {
                    inputStream = finalSocket.getInputStream();
                    inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                    bufferedReader = new BufferedReader(inputStreamReader);
                    String info = null;//临时
                    while ((info = bufferedReader.readLine()) != null) {
                        System.out.println("服务器端接收：" + "{'from_client':'" + finalSocket.getInetAddress().getHostAddress() + "','data':'" + info + "'}");
                    }

                    outputStream = finalSocket.getOutputStream();
                    writer = new OutputStreamWriter(outputStream, "UTF-8");
                    writer.write("{'to_client':'" + finalSocket.getInetAddress().getHostAddress() + "','data':'我是服务器数据'}");
                    writer.flush();//清空缓冲区数据
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        finalSocket.close();
                        inputStream.close();
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            };
            executorService.submit(task);
        }


    }


    public static void main(String[] args) {
        TcpServer server = new TcpServer();
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
