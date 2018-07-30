package com.itso.imdb.commands;

import java.io.IOException;
import java.net.MalformedURLException;

public interface Command {
    void execute() throws IOException;
}
