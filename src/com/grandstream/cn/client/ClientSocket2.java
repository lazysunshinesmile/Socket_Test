package com.grandstream.cn.client;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientSocket2 {
    private static String mServerAddress = "192.168.125.244";
    public static void main(String[] args) {
        new Thread(() -> {
            appendLog("onCreate: mServerAddress:" + mServerAddress + ", ");
//            for(int i=0; i<8; i++) {
//                if(sendMsg(2020+i*10)) {
//                    break;
//                }
//            }
            sendMsg(2020);
            /*try {
                Thread.sleep(5000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            sendMsg(Constants.SOCKET_PORT+1);*/
        }).start();
    }

    private static boolean sendMsg(int port) {
        try {
            Socket socket = new Socket();
            socket.bind(null);
            socket.connect(new InetSocketAddress(mServerAddress, port));

            appendLog("sendMsg:mServerAddress:" + mServerAddress + " port:" + port);
            appendLog("client sendMsg:mServerAddress:" + mServerAddress + " port:" + port);

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String log = "我的ip是：" + socket.getLocalAddress().getHostAddress() + ", 我连接的端口是:" + port;
            appendLog("客户端发送：ip:" + mServerAddress + ", port:" + port);
            appendLog(log);
            bufferedWriter.write(log);
            bufferedWriter.newLine();
            bufferedWriter.flush();
//            bufferedWriter.close();
            boolean temp = true;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = "";
            while (!(line = bufferedReader.readLine()).equals("over")) {

                appendLog("服务端回复：" + line);
                //                bufferedReader.close();
                //                bufferedWriter.close();
                //                bufferedWriter.close();
                //                socket.close();
            }
            return true;

        } catch(IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static void appendLog(String s) {
        System.out.println("client2:" + s);
    }
}
