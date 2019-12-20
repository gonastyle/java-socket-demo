package com.mei.rpc1.client;

import com.mei.rpc1.model.RpcRequest;
import io.netty.channel.Channel;

import java.util.UUID;

/**
 * @Description:
 * @Author: Administrator
 * @Date: 2019/12/20 10:20
 * @Version: V1.0
 **/

public class Main {

    public static void main(String[] args) throws Exception {
        NettyClient client = new NettyClient("127.0.0.1", 8080);
        //启动client服务
        client.start();

        Channel channel = client.getChannel();
        //消息体
        RpcRequest request = new RpcRequest();
        request.setId(UUID.randomUUID().toString());
        request.setData("client.message");
        //channel对象可保存在map中，供其它地方发送消息
        channel.writeAndFlush(request);
    }
}

