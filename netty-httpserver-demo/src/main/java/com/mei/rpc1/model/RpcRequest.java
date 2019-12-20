package com.mei.rpc1.model;

/**
 * @Description:
 * @Author: Administrator
 * @Date: 2019/12/20 10:12
 * @Version: V1.0
 **/

public class RpcRequest {

    private String id;
    private Object data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RpcRequest{" + "id='" + id + '\'' + ", data=" + data + '}';
    }
}

