package com.mj.study;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class MyClassLoader extends ClassLoader {

    public static void main(String[] args) throws Exception {
        // classloader加载`
        ClassLoader classLoader = new MyClassLoader();
        String className = "Hello";
        String methodName = "hello";
        Class<?> aClass = classLoader.loadClass(className);
        // 创建实例
        Object object = aClass.getDeclaredConstructor().newInstance();
        // 调用方法
        Method method = aClass.getMethod(methodName);
        // 读取xlass文件，解码运算，defineclass
        method.invoke(object);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 路径转换
        String resourcePath = name.replace(".", "/");
        // 文件后缀
        final String suffix = ".xlass";
        // 获取输入流
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(name.getClass().getPackage().getName() + resourcePath + suffix);
        byte[] targetByte = null;
        try {
            byte[] origByte = new byte[in.available()];
            in.read(origByte);
            targetByte = new byte[in.available()];
            for (int i = 0; i < origByte.length; i++) {
                targetByte[i] = (byte) (255 - origByte[i]);
            }
            return defineClass(name, targetByte, 0, targetByte.length);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return defineClass(name, targetByte, 0, targetByte.length);
    }
}
