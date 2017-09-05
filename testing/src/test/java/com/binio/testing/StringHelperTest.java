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
    public void areFirstAndLastTwoCharactersTheSame() throws Exception {
        StringHelper helper = new StringHelper();
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
        assertEquals("CDAA", helper.truncateAInFirst2Positions("CDAA"));
    }

}