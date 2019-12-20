package com.mei.rcp.client;

import com.mei.rcp.server.RpcRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: Administrator
 * @Date: 2019/12/20 13:54
 * @Version: V1.0
 **/
public class RemoteInvocationHandler implements InvocationHandler {
    private String host;
    private int port;

    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //组装请求
        RpcRequest request = new RpcRequest();
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setParameters(args);

        //通过TCP协议进行传输
        TcpTransport tcpTransport = new TcpTransport(host, port);
        Object result = tcpTransport.send(request);

        return result;
    }

}
