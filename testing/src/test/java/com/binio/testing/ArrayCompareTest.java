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
    //testing performance with timeout
    @Test(timeout=1000)
    public void testSort_performance(){
        int array[] = {21,23,4};
        for(int i=1; i<=100000000; i++) {
            array[0] = i;
            Arrays.sort(array);
        }
    }
}
