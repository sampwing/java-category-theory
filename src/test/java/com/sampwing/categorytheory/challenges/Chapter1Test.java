package com.sampwing.categorytheory.challenges;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.function.Function;

/**
 * Created by wings on 10/6/17.
 */
public class Chapter1Test {

    @Test
    public void testIdSuccess() {
        int one = 1;
        assertTrue(Chapter1.id(one).equals(one));
    }

    @Test
    public void testIdFailure() {
        int one = 1;
        int two = 2;
        assertFalse(Chapter1.id(one).equals(two));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testComposeSuccess() {
        Function<Integer, Integer> addTwo = (Integer value) -> value + 2;
        Function<Integer, Integer> timesTwo = (Integer value) -> value * 2;

        Integer input = 3;

        Function<Integer, Integer> manuallyComposedFunction = addTwo.compose(timesTwo);

        Function<Integer, Integer> composedFunction = Chapter1.compose(addTwo, timesTwo);

        assertEquals(manuallyComposedFunction.apply(input), composedFunction.apply(input));

   }
}

