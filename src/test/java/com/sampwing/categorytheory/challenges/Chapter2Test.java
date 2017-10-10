package com.sampwing.categorytheory.challenges;

import org.junit.Test;

import java.util.function.Function;
import java.util.Random;
import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by wings on 10/9/17.
 */
public class Chapter2Test {

    private double getSecondsElapsed(long nanoStartTime, long nanoEndTime) {
        long nanoTimeElapsed = nanoEndTime - nanoStartTime;
        return (double)nanoTimeElapsed / 1000000000.0;
    }

    @Test
    public void testMemoized() {
        Function<Integer, Integer> longRunningFunction = (Integer seconds) -> {
            try {
                Thread.sleep(seconds * 1000);
            } catch (Exception e) {
                return -1;
            }
            return 1;
        };

        Function<Integer, Integer> memoizedLongRunningFunction = Chapter2.memoize(longRunningFunction);

        Integer secondsToSleep = 1;

        // first invocation should take the full penalty involved with sleeping
        long nanoStartTime = System.nanoTime();
        memoizedLongRunningFunction.apply(secondsToSleep);
        long nanoEndTime = System.nanoTime();
        assertTrue(secondsToSleep <= getSecondsElapsed(nanoStartTime, nanoEndTime));

        // subsequent calls should be memoized and return the value that has been cached
        nanoStartTime = System.nanoTime();
        memoizedLongRunningFunction.apply(secondsToSleep);
        nanoEndTime = System.nanoTime();
        assertFalse(secondsToSleep <= getSecondsElapsed(nanoStartTime, nanoEndTime));
    }

    @Test
    public void testMemoizedRandomValue() {
        Random random = new Random();
        Supplier<Integer> randomNextInt = random::nextInt;

        // verify that if we memoize the randon::nextInt method that it returns the same value with each subsequent call
        Supplier<Integer> memoizedRandomNextInt = Chapter2.memoize(randomNextInt);
        Integer randomInt = memoizedRandomNextInt.get();

        assertEquals(randomInt, memoizedRandomNextInt.get());
   }
}

