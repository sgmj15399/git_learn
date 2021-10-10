package com.example.demo.proxy;

import java.lang.reflect.Proxy;

/**
 * @author minjian
 */
public class RpcClientJdk extends RpcProxy implements RpcClient {
    /**
     * 泛型生成实现类
     * @param serviceClass service class
     * @param url server url
     * @param <T>
     * @return
     */
    @Override
    public <T> T create(Class<T> serviceClass, String url) {
        // 查询是否之前生成过，存储的直接返回
        if (!isExit(serviceClass.getName())) {
            add(serviceClass.getName(), newProxy(serviceClass, url));
        }
        return (T) getProxy(serviceClass.getName());
    }

    private <T> T newProxy(Class<T> serviceClass, String url) {
        ClassLoader loader = RpcClientJdk.class.getClassLoader();
        Class[] classes = new Class[]{serviceClass};
        return (T) Proxy.newProxyInstance(loader, classes, new RpcInvocationHandler(serviceClass, url));
    }
}
