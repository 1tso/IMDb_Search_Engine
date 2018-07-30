package com.itso.imdb.local_cache;

import com.itso.imdb.shows.Movie;

public interface Cache {
    public Movie get(String title);
    public boolean contains(String title);
    public void add(Movie movie);
}
