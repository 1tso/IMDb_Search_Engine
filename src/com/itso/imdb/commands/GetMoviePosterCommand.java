package com.itso.imdb.commands;

import com.itso.imdb.local_cache.Cache;
import com.itso.imdb.shows.Movie;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import static com.itso.imdb.commands.Constants.IMAGE_TYPE;
import static com.itso.imdb.commands.Constants.POSTER_NAME_EXTENSION;

public class GetMoviePosterCommand implements Command{


    private CommandParser commandParser;
    private Cache cache;

    public GetMoviePosterCommand(CommandParser commandParser, Cache cache) {
        this.commandParser = commandParser;
        this.cache = cache;
    }

    /**
     * Gets poster from OMDb and saves it to the local file system
     * @param url
     * @throws IOException
     */
    private void savePoster(URL url) throws IOException {
        BufferedImage image = ImageIO.read(url);
        ImageIO.write(image, IMAGE_TYPE, new File(getTitle()+ POSTER_NAME_EXTENSION));
    }

    @Override
    public void execute() throws IOException {
        String title = getTitle();
        if (cache.contains(title)) {
            Movie movie = cache.get(title);
            savePoster((new URL(movie.getPoster())));
        } else {
            throw new IllegalArgumentException();
        }
    }

    private String getTitle() {
        return commandParser.getTarget().replace("+", " ");
    }
}
