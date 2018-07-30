package com.itso.imdb.server;

import com.itso.imdb.local_cache.Cache;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;


/**
 * Creates threads for every connecting client
 */
public class IMDb_Server  {

    private static final int DEF_PORT = 4444;

    public static void main(String[] args) {
        Cache cache = new Cache();
        try (ServerSocket ss = new ServerSocket(DEF_PORT)) {
            while (true) {
                Socket client = ss.accept();
                new Thread(new IMDb_ServerRunnable(client,cache)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
