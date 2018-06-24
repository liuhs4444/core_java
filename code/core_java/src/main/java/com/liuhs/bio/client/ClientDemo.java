package com.liuhs.bio.client;

import java.io.*;
import java.net.Socket;

public class ClientDemo {

    public static void main(String[] args) {

        try {
            // 创建socket对象，和服务器端建立连接
            Socket socket = new Socket("localhost", 9999);

            // 获取客户端对应的输入输出流
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();

            // 对原始输入输出流进行包装
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            PrintWriter printWriter = new PrintWriter(outputStream);

            // 给服务端发送数据
            printWriter.println("hello, server ... ");
            printWriter.flush();

            outputStream.close();
            inputStream.close();
            bufferedReader.close();
            printWriter.close();
            socket.close();

        } catch (IOException e) {

        }
    }
}
