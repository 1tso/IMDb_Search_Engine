import com.itso.imdb.commands.CommandParser;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by itso on 2/16/18.
 */
public class CommandParserTest {
    @Test
    public void GivenCorrectInputShouldReturnCorrectTarget() throws IllegalAccessException {
        String test = "get-movie Titanic";
        String answer = "Titanic";
        CommandParser commandParser = new CommandParser(test);
        assertEquals(commandParser.getTarget(), answer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void GivenMissingTargetShoulThrowException()  {
        String test = "get-movie";
        CommandParser commandParser = new CommandParser(test);
        commandParser.getTarget();
    }

    @Test
    public void GivenCorrectInputShouldReturnOptionValue()  {
        String test = "get-movie guardians of the galaxy --fields=Title";
        String answer = "Title";
        CommandParser commandParser = new CommandParser(test);
        List<String> lst = commandParser.getOptionValue("fields");
        assertEquals(lst.get(0),answer);
    }
}