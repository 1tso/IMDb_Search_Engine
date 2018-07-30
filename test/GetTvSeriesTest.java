import com.itso.imdb.commands.CommandParser;
import com.itso.imdb.commands.GetTvSeriesCommand;
import com.itso.imdb.local_cache.MapCache;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GetTvSeriesTest {

    @Test
    public void GivenCorrectCommandShouldReturnCorrectEpisodes() throws IOException {
        String input = "get-tv-series Friends --season=3";
        CommandParser commandParser = new CommandParser(input);
        MapCache movies = new MapCache();
        GetTvSeriesCommand getTvSeries = new GetTvSeriesCommand(commandParser,movies);
        getTvSeries.execute();
        String actual = "{\"Title\":\"Friends\",\"Season\":\"3\",\"totalSeasons\":\"10\",\"Episodes\":[{\"Title\":\"The One with the Princess Leia Fantasy\",\"Released\":\"1996-09-16\",\"Episode\":\"1\",\"imdbRating\":\"8.5\",\"imdbID\":\"tt0583634\"},{\"Title\":\"The One Where No One's Ready\",\"Released\":\"1996-09-26\",\"Episode\":\"2\",\"imdbRating\":\"9.0\",\"imdbID\":\"tt0583464\"},{\"Title\":\"The One with the Jam\",\"Released\":\"1996-10-03\",\"Episode\":\"3\",\"imdbRating\":\"8.2\",\"imdbID\":\"tt0583619\"},{\"Title\":\"The One with the Metaphorical Tunnel\",\"Released\":\"1996-10-10\",\"Episode\":\"4\",\"imdbRating\":\"8.2\",\"imdbID\":\"tt0583629\"},{\"Title\":\"The One with Frank Jr.\",\"Released\":\"1996-10-17\",\"Episode\":\"5\",\"imdbRating\":\"8.2\",\"imdbID\":\"tt0583520\"},{\"Title\":\"The One with the Flashback\",\"Released\":\"1996-10-31\",\"Episode\":\"6\",\"imdbRating\":\"9.1\",\"imdbID\":\"tt0583606\"},{\"Title\":\"The One with the Race Car Bed\",\"Released\":\"1996-11-07\",\"Episode\":\"7\",\"imdbRating\":\"8.4\",\"imdbID\":\"tt0583637\"},{\"Title\":\"The One with the Giant Poking Device\",\"Released\":\"1996-11-14\",\"Episode\":\"8\",\"imdbRating\":\"8.5\",\"imdbID\":\"tt0583609\"},{\"Title\":\"The One with the Football\",\"Released\":\"1996-11-21\",\"Episode\":\"9\",\"imdbRating\":\"9.1\",\"imdbID\":\"tt0583607\"},{\"Title\":\"The One Where Rachel Quits\",\"Released\":\"1996-12-12\",\"Episode\":\"10\",\"imdbRating\":\"8.2\",\"imdbID\":\"tt0583474\"},{\"Title\":\"The One Where Chandler Can't Remember Which Sister\",\"Released\":\"1997-01-09\",\"Episode\":\"11\",\"imdbRating\":\"8.6\",\"imdbID\":\"tt0583443\"},{\"Title\":\"The One with All the Jealousy\",\"Released\":\"1997-01-16\",\"Episode\":\"12\",\"imdbRating\":\"8.3\",\"imdbID\":\"tt0583506\"},{\"Title\":\"The One Where Monica and Richard Are Just Friends\",\"Released\":\"1997-01-30\",\"Episode\":\"13\",\"imdbRating\":\"8.3\",\"imdbID\":\"tt0583461\"},{\"Title\":\"The One with Phoebe's Ex-Partner\",\"Released\":\"1997-02-06\",\"Episode\":\"14\",\"imdbRating\":\"8.0\",\"imdbID\":\"tt0583538\"},{\"Title\":\"The One Where Ross and Rachel Take a Break\",\"Released\":\"1997-02-13\",\"Episode\":\"15\",\"imdbRating\":\"8.6\",\"imdbID\":\"tt0583487\"},{\"Title\":\"The One the Morning After\",\"Released\":\"1997-02-20\",\"Episode\":\"16\",\"imdbRating\":\"9.1\",\"imdbID\":\"tt0583501\"},{\"Title\":\"The One Without the Ski Trip\",\"Released\":\"1997-03-06\",\"Episode\":\"17\",\"imdbRating\":\"8.4\",\"imdbID\":\"tt0583495\"},{\"Title\":\"The One with the Hypnosis Tape\",\"Released\":\"1997-03-13\",\"Episode\":\"18\",\"imdbRating\":\"8.5\",\"imdbID\":\"tt0583615\"},{\"Title\":\"The One with the Tiny T-Shirt\",\"Released\":\"1997-03-27\",\"Episode\":\"19\",\"imdbRating\":\"8.3\",\"imdbID\":\"tt0583654\"},{\"Title\":\"The One with the Dollhouse\",\"Released\":\"1997-04-10\",\"Episode\":\"20\",\"imdbRating\":\"8.2\",\"imdbID\":\"tt0583596\"},{\"Title\":\"The One with the Chick and the Duck\",\"Released\":\"1997-04-17\",\"Episode\":\"21\",\"imdbRating\":\"8.8\",\"imdbID\":\"tt0583590\"},{\"Title\":\"The One with the Screamer\",\"Released\":\"1997-04-24\",\"Episode\":\"22\",\"imdbRating\":\"8.4\",\"imdbID\":\"tt0583643\"},{\"Title\":\"The One with Ross's Thing\",\"Released\":\"1997-05-01\",\"Episode\":\"23\",\"imdbRating\":\"8.2\",\"imdbID\":\"tt0583565\"},{\"Title\":\"The One with the Ultimate Fighting Champion\",\"Released\":\"1997-05-08\",\"Episode\":\"24\",\"imdbRating\":\"8.3\",\"imdbID\":\"tt0583657\"},{\"Title\":\"The One at the Beach\",\"Released\":\"1997-05-15\",\"Episode\":\"25\",\"imdbRating\":\"8.9\",\"imdbID\":\"tt0583496\"}],\"Response\":\"True\"}";
        assertEquals(getTvSeries.getResult(),actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void GivenCommandWithNoSeasonParameterShouldReturnException() throws IOException {
        String input = "get-tv-series Cheers";
        CommandParser commandParser = new CommandParser(input);
        GetTvSeriesCommand getTvSeries = new GetTvSeriesCommand(commandParser, new MapCache());
        getTvSeries.execute();
    }

}
