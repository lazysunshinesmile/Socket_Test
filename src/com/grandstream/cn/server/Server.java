package com.grandstream.cn.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            serverSocket.setReuseAddress(true);
            Socket socket = serverSocket.accept();

//            Scanner scan =new Scanner(socket.getInputStream());//控制台输入流
//            PrintWriter pw = new PrintWriter(socket.getOutputStream());//控制台输出流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

//            String str =scan.nextLine();//读取控制台的录入
            String str = bufferedReader.readLine();
            System.out.println("客户说："+str);
            bufferedWriter.write("前世的五百次回眸·\n");
//            bufferedWriter.newLine();
            bufferedWriter.flush();
//            pw.println("前世的五百次回眸·");
//            pw.flush();


            System.out.println("用户已加入！");

            /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = bufferedReader.readLine();
            System.out.println("客户端说：" + line);

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String say = "我是服务器";
            System.out.println(say);
            bufferedWriter.write(say);
            bufferedWriter.flush();*/






        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
