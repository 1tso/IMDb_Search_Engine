package com.itso.imdb.server;

import com.itso.imdb.commands.*;
import com.itso.imdb.local_cache.Cache;
import com.itso.imdb.local_cache.MapCache;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Current thread
 */
public class IMDb_ServerRunnable implements Runnable {

    private Socket socket;

    private CommandParser commandParser;
    private Cache cache;

    public IMDb_ServerRunnable(Socket socket, Cache cache) {
        this.socket = socket;
        this.cache = cache;
    }

    public Map<String, Command> initializeCommands() {
        Map<String,Command> commands = new HashMap<>();
        commands.put("get-movie", new GetMovieCommand(commandParser,cache));
        commands.put("get-tv-series", new GetTvSeriesCommand(commandParser,cache));
        commands.put("get-movie-poster", new GetMoviePosterCommand(commandParser,cache));

        return commands;
    }


    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String msg = reader.readLine();
            this.commandParser = new CommandParser(msg);
            Map<String,Command> commands = initializeCommands();
            Command current = commands.get(commandParser.getName());
            current.execute();

            } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
