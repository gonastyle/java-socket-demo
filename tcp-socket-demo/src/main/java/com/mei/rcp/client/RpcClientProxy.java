package com.mei.rcp.client;

import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Author: Administrator
 * @Date: 2019/12/20 13:53
 * @Version: V1.0
 **/
public class RpcClientProxy {
    public <T> T clientProxy(final Class<T> interfceClass, final String host, final int port) {

        return (T) Proxy.newProxyInstance(interfceClass.getClassLoader(),
                new Class[]{interfceClass}, new RemoteInvocationHandler(host, port));
    }

}
