package com.itso.imdb.commands;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

import java.util.List;

/**
 * Used to mark fields which should be returned when parsed to Json
 */
public class CustomExclusionStrategy implements ExclusionStrategy {
    private List list;

    public CustomExclusionStrategy(List list) {
        this.list = list;
    }

    @Override
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        if (list != null) {
            return !list.contains(fieldAttributes.getName());
        } else return false;

    }

    @Override
    public boolean shouldSkipClass(Class<?> aClass) {
        return false;
    }
}
