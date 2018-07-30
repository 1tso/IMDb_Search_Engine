package com.itso.imdb.client;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * The client sends requests(String) to the server, getting the input from the command line
 */
public class Client implements Runnable {

    private static final int PORT = 4444;
    private int port;

    public Client() {
        this.port = PORT;
    }

    @Override
    public void run() {
        System.out.println("Please enter your commandParser");
        Scanner in = new Scanner(System.in);
        String command = in.nextLine();
        try (Socket s = new Socket("localhost", port);
             PrintWriter pw = new PrintWriter(s.getOutputStream())) {
            pw.println(command);
            pw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
