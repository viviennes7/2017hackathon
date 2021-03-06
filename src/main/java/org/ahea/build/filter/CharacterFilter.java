package org.ahea.build.filter;

import lombok.extern.apachecommons.CommonsLog;

import java.util.function.Predicate;

public class CharacterFilter implements Filter<String> {

    Predicate<String> condition;

    public CharacterFilter(Predicate<String> condition) {
        this.condition = condition;
    }

    @Override
    public Boolean filter(String value) {
        return condition.test(value);
    }

}
