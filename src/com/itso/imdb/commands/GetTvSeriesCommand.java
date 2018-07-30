package com.itso.imdb.commands;
import com.itso.imdb.local_cache.Cache;

import java.io.IOException;

import java.net.URL;
import java.util.List;

import static com.itso.imdb.commands.Constants.*;

public class GetTvSeriesCommand extends AbstractCommand {

    public GetTvSeriesCommand(CommandParser commandParser, Cache cache) {
        super(commandParser, cache);
    }

    @Override
    public void execute() throws IOException {
        List<String> season = commandParser.getOptionValue("season");
        if (season == null) {
            throw new IllegalArgumentException("Please enter season");
        } else {
            result = getJson(new URL(DATA_URL_STR + commandParser.getTarget() + SEASON + Integer.parseInt(season.get(SEASON_VALUE_INDEX)) + API_KEY));
        }
        printJson();
    }
}
