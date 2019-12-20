package com.mei.rpc1.model;

/**
 * @Description:
 * @Author: Administrator
 * @Date: 2019/12/20 10:13
 * @Version: V1.0
 **/
public class RpcResponse {

    private String id;
    private Object data;
    // 0=success -1=fail
    private int status;

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RpcResponse{" + "id='" + id + '\'' + ", data=" + data + ", status=" + status + '}';
    }
}

