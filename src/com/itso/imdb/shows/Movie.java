package com.itso.imdb.shows;

import java.io.Serializable;

/**
 * Class used for serialization
 */
public class Movie implements Serializable {
    private String Title;
    private String Year;
    private String Rated;
    private String Released;
    private String Runtime;
    private String Genre;
    private String Director;
    private String Writer;
    private String Actors;
    private String Plot;
    private String Language;
    private String Country;
    private String Awards;
    private String Poster;
    private String Rating;
    private String Metascore;
    private String imdbRating;
    private String ImdbVotes;
    private String ImdbID;
    private String Type;
    private String Dvd;
    private String BoxOffice;
    private String Production;
    private String Website;
    private String totalSeasons;


    public String getTitle() {
        return Title;
    }
    public String getPoster() {
        return Poster;
    }
}
