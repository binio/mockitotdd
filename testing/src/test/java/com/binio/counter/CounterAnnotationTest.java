package com.binio.counter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
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

    @Test
    public void test() {
        when(generator.generateFriendly()).thenReturn(6);
        String actual = counter.getResult(generator.generateFriendly());
        assertEquals(actual,"OK");
    }
}
