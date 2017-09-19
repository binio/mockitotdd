package com.binio.counter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

/**
 * Created by tomasz.biniecki on 19/09/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class CounterAnnotationTest {

    @InjectMocks
    Counter counter;

    @Mock
    NumGenerator generator;

    @Before
    public void setUp(){
        when(generator.generate()).thenReturn(5);
    }

    @Test
    public void testShouldReturnOKforValueSix() {
        when(generator.generateFriendly()).thenReturn(6);
        String actual = counter.getResult(generator.generateFriendly());
        assertEquals("OK", actual);
    }
    @Test
    public void testShouldFailForValue5() {
        //System.out.println(generator.generate());
        String actual = counter.getResult(generator.generate());
        assertNotEquals("OK", actual);
    }
}
