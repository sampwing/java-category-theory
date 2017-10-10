package com.sampwing.categorytheory.challenges;

import java.util.function.Function;

public class Chapter1 {
    public static <T> T id(T element) {
        return element;
    }

    @SuppressWarnings("unchecked")
    public static <T> Function<T, T> compose(Function<T, T> ...functions) {

        Function<T, T> composed = null;
        for (Function<T, T> function : functions) {
            if (composed == null) {
                composed = function;
            } else {
                composed = composed.compose(function);
            }

        }
        return composed;
    }
}
