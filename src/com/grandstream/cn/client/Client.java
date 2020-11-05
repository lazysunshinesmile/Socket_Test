package com.grandstream.cn.client;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {

            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("127.0.0.1", 9999));
            System.out.println("快乐的与服务器连接上了、");
//            Scanner scan = new Scanner(socket.getInputStream());
//            PrintWriter pw =  new PrintWriter(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));


            System.out.println("输入要发给服务端的内容：");
//            pw.println("只为换取今世的一次邂逅。");
//            pw.flush();
            bufferedWriter.write("只为换取今世的一次邂逅。\n");
//            bufferedWriter.newLine();
            bufferedWriter.flush();

//            String str = scan.nextLine();
            String str = bufferedReader.readLine();
            System.out.println("服务器说："+str);






           /* socket.connect(new InetSocketAddress("127.0.0.1", 9999));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("我是客户端");
            bufferedWriter.flush();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = bufferedReader.readLine();
            System.out.println("服务端说：" +line);*/


        }catch(IOException a) {

        }

    }
}
