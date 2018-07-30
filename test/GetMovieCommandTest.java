import com.itso.imdb.commands.*;
import com.itso.imdb.local_cache.Cache;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;


import static org.junit.Assert.*;

/**
 * Created by itso on 2/16/18.
 */
public class GetMovieCommandTest {

    @Test
    public void GivenCommandWithFieldsShouldReturnRequestedField() throws MalformedURLException {

        String input = "get-movie Guardians of the Galaxy --fields=Year";
        String actual = "{\"Year\":\"2014\"}";
        CommandParser commandParser = new CommandParser(input);
        Cache cache =  new Cache();
        GetMovieCommand getMovie = new GetMovieCommand(commandParser, cache);
        GetMovieCommand secondMovie = new GetMovieCommand(commandParser,cache);
        getMovie.execute();
        secondMovie.execute();
        assertEquals(actual, secondMovie.getResult());
    }

    @Test(expected = IllegalArgumentException.class)
    public void GivenNamelessCommandShoudThrowException() throws IOException {
        String command = "frozen --fields=Year";
        CommandParser commandParser = new CommandParser(command);
        Command getMovie = new GetMovieCommand(commandParser,new Cache());
        getMovie.execute();
    }


    @Test(expected = IllegalArgumentException.class)
    public void GivenCommandWithIncorrectInputShouldThrowException() throws MalformedURLException {
        String command = "get-movie--fields=Year";
        CommandParser commandParser = new CommandParser(command);
        GetMovieCommand getMovie = new GetMovieCommand(commandParser, new Cache());
        getMovie.execute();

    }


}