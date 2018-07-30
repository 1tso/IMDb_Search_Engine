import com.itso.imdb.commands.CommandParser;
import com.itso.imdb.commands.GetMovieCommand;
import com.itso.imdb.commands.GetMoviePosterCommand;
import com.itso.imdb.local_cache.MapCache;
import org.junit.Test;

import java.io.IOException;

public class GetMoviePosterCommandTest {


    @Test
    public void givenCommandShouldReturnPoster() throws IOException {
        String command = "get-movie-poster Frozen";
        String secondCommand = "get-movie Frozen";
        MapCache cache = new MapCache();
        CommandParser posterCommand = new CommandParser(command);
        CommandParser movieCommand = new CommandParser(secondCommand);
        GetMovieCommand getMovie = new GetMovieCommand(movieCommand,cache);
        GetMoviePosterCommand getMoviePoster = new GetMoviePosterCommand(posterCommand,cache);
        getMovie.execute();
        getMoviePoster.execute();
    }
}
