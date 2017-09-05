package com.binio.testing;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tomasz.biniecki on 05/09/2017.
 */
public class StringHelperTest {
    @Test
    public void truncateAInFirst2Positions() throws Exception {
        //fail("Not implemented");
    }

    @Test
    public void truncateAInFirstTwoPositions_whenTwoAPresentAtTheBegining() throws Exception {
        StringHelper helper = new StringHelper();
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
    }

    @Test
    public void truncateAInFirstTwoPositions_whenOneAPresentAtTheBegining() throws Exception {
        StringHelper helper = new StringHelper();
        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
    }

    @Test
    public void truncateAInFirstTwoPositions_whenNoAPresentAtTheBegining() throws Exception {
        StringHelper helper = new StringHelper();
        assertEquals("CDAA", helper.truncateAInFirst2Positions("CDAA"));
    }



}