package com.itso.imdb.local_cache;

import com.itso.imdb.shows.Movie;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    private Map<String, Movie> cache;

    public Cache() {
        this.cache = new HashMap<>();
    }

    public synchronized Movie get(String title) {
        return cache.get(title);
    }

    public synchronized boolean contains(String title) {
        return cache.containsKey(title);
    }

    public synchronized void add(Movie movie) {
        cache.put(movie.getTitle(),movie);
    }
}
