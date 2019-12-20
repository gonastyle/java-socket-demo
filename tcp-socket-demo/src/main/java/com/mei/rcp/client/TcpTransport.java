package com.mei.rcp.client;

import com.mei.rcp.server.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @Description:
 * @Author: Administrator
 * @Date: 2019/12/20 13:55
 * @Version: V1.0
 **/
public class TcpTransport {
    private String host;
    private int port;

    public TcpTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    //创建一个socket连接
    private Socket netSocket() {
        System.out.println("创建一个连接");
        Socket socket = null;

        try {
            socket = new Socket(host, port);
            return socket;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //发送
    public Object send(RpcRequest rpcRequest) {
        Socket socket = null;

        try {
            socket = netSocket();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(rpcRequest);
            objectOutputStream.flush();

            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object result = objectInputStream.readObject();
            objectOutputStream.close();
            objectInputStream.close();
            return result;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
