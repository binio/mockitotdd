package com.binio.counter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by tomasz.biniecki on 12/09/2017.
 */
@RunWith(Parameterized.class)
public class CounterTest {

    private String input;
    private String expectedOutput;

    public CounterTest(String input, String expectedOutput) {
        super();
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection testConditions(){
        String expectedOutputs[][] = {{"6", "OK"},{"12","OK"},{"18","OK"},{"36","OK"},{"300","OK"},{"301","NOT OK"},{"10","NOT OK"},{"5","NOT OK"}};
        return Arrays.asList(expectedOutputs);
    }

    @Test
    public void testCounterCount_InputDividedByTwoAndThreeParametrized() {
        Counter counter = new Counter();
        String actual = counter.getResult(Integer.parseInt(input));
        assertEquals(expectedOutput,actual);
    }


}