package com.itso.imdb.commands;

import com.itso.imdb.local_cache.Cache;
import com.itso.imdb.local_cache.MapCache;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class AbstractCommand implements Command {
    CommandParser commandParser;
    String result;
    Cache cache;

    AbstractCommand(CommandParser commandParser, Cache cache) {
        this.commandParser = commandParser;
        this.cache = cache;
    }

    /**
     *Connects to the OMDbAPI
     * @param url
     * @return HttpURLConnection
     * @throws IOException
     */

    private HttpURLConnection getConnectionToOMDb(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        return connection;
    }

    /**
     * Reads the required content from OMDb
     * @param url
     * @return String
     */
    String getJson(URL url) {
        StringBuilder json = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getConnectionToOMDb(url).getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Problem with connection");
        }
        return json.toString();
    }

    /**
     * Returns result, necessary for testing
     * @return String
     */

    public String getResult() {
        return result;
    }

    /**
     * Returns title of movie from commandParaser
     * @return String
     */

    String getTitle() {
        return commandParser.getTarget().replace("+", " ");
    }

    void printJson() {
        System.out.println(result);
    }
}
