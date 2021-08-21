package com.mj.study.week2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ：minjian
 * @version ：V3.3
 * @program ：open-logistic
 * @date: 2021/8/15 17:05
 * @description ：
 */
public class MyHttpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8801);
        while(true){
            Socket socket = serverSocket.accept();
            handlerSocket(socket);
        }

    }

    private static void handlerSocket(Socket socket) {
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html; charset=utf-8");
            String body = "hello httpServer";
            printWriter.println("Content-Length:"+body.length());
            printWriter.println();
            printWriter.write(body);
            printWriter.close();
            socket.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}