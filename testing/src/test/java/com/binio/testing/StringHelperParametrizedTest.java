package com.binio.testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by tomasz.biniecki on 05/09/2017.
 */
@RunWith(Parameterized.class)
public class StringHelperParametrizedTest {

    StringHelper helper;

    private String input;
    private String expectedOutput;

    public StringHelperParametrizedTest(String input, String expectedOutput) {
        super();
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameters
    public static Collection testConditions(){
        String expectedOutputs[][] = {{"AACD", "CD"},{"ACD","CD"}};
        return Arrays.asList(expectedOutputs);
    }

    @Before
    public void setup() {
        helper = new StringHelper();
        System.out.println("run before test...");
    }

    @Test
    public void truncateAInFirstTwoPositions_whenTwoAPresentAtTheBegining() throws Exception {
        assertEquals(expectedOutput, helper.truncateAInFirst2Positions(input));
    }

//    @Test
//    public void truncateAInFirstTwoPositions_whenOneAPresentAtTheBegining() throws Exception {
//        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
//    }

    @Test
    public void truncateAInFirstTwoPositions_whenNoAPresentAtTheBegining() throws Exception {
        assertEquals("CDAA", helper.truncateAInFirst2Positions("CDAA"));
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_basicScenario() throws Exception {
        assertEquals(false, helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_basicPositiveScenario() throws Exception {
        assertEquals(true, helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
    }

    @After
    public void teardown() {
        System.out.println("run after test...");
    }


}