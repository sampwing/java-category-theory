package com.sampwing.categorytheory.challenges;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wings on 10/10/17.
 */
public class Chapter3Test {

    private Chapter3.BooleanMonoid mBoolTrue = new Chapter3().new BooleanMonoid(true);
    private Chapter3.BooleanMonoid mBoolFalse = new Chapter3().new BooleanMonoid(false);

    @Test
    public void testBoolTrueAndFalse() {
        assertEquals(mBoolFalse, mBoolTrue.and(mBoolFalse));
    }

    @Test
    public void testBoolTrueAndTrue() {
        assertEquals(mBoolTrue, mBoolTrue.and(mBoolTrue));
    }

    @Test
    public void testBoolTrueOrFalse() {
        assertEquals(mBoolTrue, mBoolTrue.or(mBoolFalse));
    }

    @Test
    public void testBoolFalseOrFalse() {
        assertEquals(mBoolFalse, mBoolFalse.or(mBoolFalse));
    }
}

