package com.example.poc.lowhighIntegratePlatform.infra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class SocketClient {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    /**
     * @param ip
     * @param port
     * @throws IOException
     */
    public void start(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    /**
     * @param msg
     * @return
     * @throws IOException
     */
    public String send(String msg) throws IOException {
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }

    /**
     *
     */
    public void stop() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
