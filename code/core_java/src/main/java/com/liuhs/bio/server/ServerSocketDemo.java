package com.liuhs.bio.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {

    public static void main(String[] args) {

        try {
            // create server socket
            ServerSocket serverSocket = new ServerSocket(9999);

            // 接受客户端请求
            // 此方法默认是阻塞的，当有新的请求来时，此方法会被唤醒
            Socket accept = serverSocket.accept();

            // 获取输入输出流：用来和客户端进行数据交互
            InputStream inputStream = accept.getInputStream();

            OutputStream outputStream = accept.getOutputStream();

            // 对原始输入流进行包装
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            // 对原始输出流进行包装
            PrintWriter printWriter = new PrintWriter(outputStream);

            // 读取客户端传递的参数
            String clientMsg = bufferedReader.readLine();

            System.out.println("server : client send msg ==> " + clientMsg);

            // 给客户端的响应
            /*printWriter.print("success");
            printWriter.flush();*/

        } catch (Exception e) {

        }

    }
}
