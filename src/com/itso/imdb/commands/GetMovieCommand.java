package com.itso.imdb.commands;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itso.imdb.local_cache.Cache;
import com.itso.imdb.local_cache.MapCache;
import com.itso.imdb.shows.Movie;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static com.itso.imdb.commands.Constants.DATA_URL_STR;
import static com.itso.imdb.commands.Constants.API_KEY;
import static com.itso.imdb.commands.Constants.FIELDS;

public class GetMovieCommand extends AbstractCommand {

    public GetMovieCommand(CommandParser commandParser, Cache cache) {
        super(commandParser, cache);
    }

    /**
     * Returns gson with exclusionStrategy, depending on the number of fields
     * @return Gson
     */
    private Gson setExclusionStrategy() {
        Gson gson;
        List<String> fields = commandParser.getOptionValue(FIELDS);
        if (fields == null) {
            gson = new Gson();
        } else {
            gson = new GsonBuilder().setExclusionStrategies(new CustomExclusionStrategy(fields)).create();
        }
        return gson;
    }

    /**
     * Converts json to Movie
     * @return
     */

    private Movie getMovie() {
        Gson gson = new Gson();
        return gson.fromJson(result, Movie.class);
    }

    /**
     * Converts Movie to json
     * @param movie
     */

    private void convertToJson(Movie movie) {
        Gson gson = setExclusionStrategy();
        result = gson.toJson(movie);
        if (result.equals("null")) {
            throw new IllegalArgumentException("No movie with such name");
        }
        printJson();
    }


    @Override
    public void execute() throws MalformedURLException {
        String title = getTitle();
        if (!cache.contains(title)) {
            result = getJson(new URL(DATA_URL_STR + commandParser.getTarget() + API_KEY));
            cache.add(getMovie());
        }
        convertToJson(cache.get(title));
    }
}
