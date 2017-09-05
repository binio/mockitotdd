package com.binio.testing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tomasz.biniecki on 05/09/2017.
 */
public class StringHelperTest {

    StringHelper helper;

    @Before
    public void setup(){
        helper = new StringHelper();
    }

    @Test
    public void truncateAInFirstTwoPositions_whenTwoAPresentAtTheBegining() throws Exception {
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
    }

    @Test
    public void truncateAInFirstTwoPositions_whenOneAPresentAtTheBegining() throws Exception {
        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
    }

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



}