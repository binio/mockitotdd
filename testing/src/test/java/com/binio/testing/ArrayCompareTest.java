package com.binio.testing;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by tomasz.biniecki on 06/09/2017.
 */
public class ArrayCompareTest {

    //Arrays.sort

    @Test
    public void testArraySort_randomArray() {
        //assertEquals will not work
        int[] numbers = {12,3,4,1};
        int[] expected = {1,3,4,12};
        Arrays.sort(numbers);
        assertArrayEquals(expected,numbers);
    }

    @Test(expected=NullPointerException.class)
    public void testArraySort_nullArray() {
        //assertEquals will not work
        int[] numbers = null;
        int[] expected = {1,3,4,12};

            Arrays.sort(numbers);
            assertArrayEquals(expected, numbers);

    }
}
