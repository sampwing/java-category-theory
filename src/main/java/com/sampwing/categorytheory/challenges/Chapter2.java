package com.sampwing.categorytheory.challenges;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.HashMap;

public class Chapter2 {

    public static <T, R> Function<T, R> memoize(Function<T, R> function) {
        HashMap<T, R> hashMap = new HashMap<>();

        // memoized method
        return (T argument) -> {
            if (!hashMap.containsKey(argument)) {
                hashMap.put(argument, function.apply(argument));
            }
            return hashMap.get(argument);
        };
    }

    public static <R> Supplier<R> memoize(Supplier<R> supplier) {
        AtomicReference<R> value = new AtomicReference<>();
        return () -> {
            if (value.get() == null) {
                synchronized (value) {
                    value.set(supplier.get());
                }
            }
            return value.get();
        };
    }
}

