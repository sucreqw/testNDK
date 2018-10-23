package com.sucre.testndk;

import com.sina.weibo.WeiboApplication;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketThread implements Runnable {

    ServerSocket serverSocket = null;
    @Override
    public void run() {
        // 声明一个ServerSocket对象

        try {
            // 创建一个ServerSocket对象，并让这个Socket在1989端口监听
            serverSocket = new ServerSocket(1989);
            // 调用ServerSocket的accept()方法，接受客户端所发送的请求，
            // 如果客户端没有发送数据，那么该线程就停滞不继续
            Socket socket = serverSocket.accept();
            // 从Socket当中得到InputStream对象
            InputStream inputStream = socket.getInputStream();
            byte buffer[] = new byte[1024 * 4];
            int temp = 0;
            // 从InputStream当中读取客户端所发送的数据
            while ((temp = inputStream.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, temp));
            }
            WeiboApplication i=new WeiboApplication();
            String ret=i.newCalculateS("test");
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(ret.getBytes());
            // 发送读取的数据到服务端
            outputStream.flush();

            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
