package com.itso.imdb.commands;

final class Constants {

    static final String DATA_URL_STR = "http://www.omdbapi.com/?t=";
    static final String API_KEY = "&apikey=4e825abb";
    static final String SEASON = "&Season=";
    static final String COMMAND_IDENTIFIER = "get-";
    static final String REGEX_SPACE = "\\s";
    static final int KEY_INDEX = 0;
    static final int VALUE_INDEX = 1;
    static final String COMMAND_SEPARATOR = "--";
    static final String NULL_VALUE = "null";
    static final String FIELDS = "fields";
    static final int SEASON_VALUE_INDEX = 0;
    static final String IMAGE_TYPE = "jpg";
    static final String POSTER_NAME_EXTENSION = "_poster.jpg";
    private Constants() {
    }
}
