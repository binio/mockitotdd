package com.binio.counter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by tomasz.biniecki on 12/09/2017.
 */
public class CounterDependencyTest {

    NumGenerator generator = mock(NumGenerator.class);

    @Test
    public void test() {
        when(generator.generate()).thenReturn(6).thenReturn(5).thenReturn(0);
        Counter counter = new Counter(generator);
        assertEquals("OK", counter.getResult(counter.generator.generate()));
        assertEquals("NOT OK", counter.getResult(counter.generator.generate()));
    }

    @Test
    public void generateFriendly() {
        when(generator.generateFriendly()).thenReturn(6).thenReturn(12).thenReturn(18);
        Counter counter = new Counter(generator);
        assertEquals("OK", counter.getResult(counter.generator.generateFriendly()));
    }
}
