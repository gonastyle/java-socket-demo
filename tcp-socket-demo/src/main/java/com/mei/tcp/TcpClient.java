package com.mei.tcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: Administrator
 * @Date: 2019/11/23 21:07
 * @Version: V1.0
 **/
public class TcpClient {

    private String ip = "127.0.0.1";

    private int port = 65535;

    public TcpClient() {
    }

    public TcpClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void start() {
        Socket socket = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            socket = new Socket(ip, port);
            outputStream = socket.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
            writer.write("ABC");
            writer.flush();
            socket.shutdownOutput();

            inputStream = socket.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String info = null;
            while ((info = bufferedReader.readLine()) != null) {
                System.out.println("客户端接收：" + info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {

                socket.close();
                outputStream.close();
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("连接结束");

    }

    public void getConsoleInput() {
        System.out.println("请输入数据：");
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        System.out.println(data);
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 1; i++) {
            pool.submit(() -> {
                TcpClient cient = new TcpClient();
                cient.start();
            });

        }


    }
}
