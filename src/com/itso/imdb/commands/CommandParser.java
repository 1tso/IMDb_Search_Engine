package com.itso.imdb.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.itso.imdb.commands.Constants.*;

/**
 * Created by itso on 2/14/18.
 */
public class CommandParser {

    private String name;
    private String input;
    private String target;
    private Map<String, List<String>> options;

    /**
     * Constructs options from a given String
     * @param option
     */

    private void constructOptions(String option) {

        option = option.replaceAll(COMMAND_SEPARATOR, "");
        String[] optionComponent = option.split("=");
        String key = optionComponent[KEY_INDEX];
        String[] valueComponents = optionComponent[VALUE_INDEX].split(",");
        ArrayList values = new ArrayList();
        for (String s : valueComponents) {
            values.add(s);
        }

        options.put(key, values);
    }

    /**
     * Constructs commands form a given string
     */
    private void initialize() {
        String[] commandComponents = input.split(REGEX_SPACE);
        for (String component : commandComponents) {
            if (component.contains(COMMAND_IDENTIFIER)) {
                name = component;
            } else if (component.contains(COMMAND_SEPARATOR)) {
                constructOptions(component);
            } else {
                target += " " + component;
            }
        }
        if (target != null) {
            target = target.replace(NULL_VALUE, "");
            target = target.substring(VALUE_INDEX);
            target = target.replaceAll(REGEX_SPACE, "+");
        }

    }

    public CommandParser(String input) {
        this.input = input;
        options = new HashMap<>();
        initialize();
    }


    public String getName() {
        return this.name;
    }

    public String getTarget() throws IllegalArgumentException {
        if (isTargetNull()) {
            throw new IllegalArgumentException(" Target does not exist");
        } else {
            return this.target;
        }
    }

    private boolean isTargetNull() {
        return target == null;
    }

    public List<String> getOptionValue(String element) {
        return options.get(element);
    }
}
