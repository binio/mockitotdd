package com.binio.counter;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.isA;
import static org.mockito.Matchers.isNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.given;

/**
 * Created by tomasz.biniecki on 18/09/2017.
 */
public class CounterSpyTest {

    public Counter counter;
    public NumGenerator generator;

    @Before
    public void setup() {
        counter = new Counter(generator);
    }

    @Test
    public void testGenerateFriendly(){
        //Given
        generator = mock(NumGenerator.class);
        given(generator.generateFriendly()).willReturn(6);

        //When
        String result = counter.getResult(generator.generateFriendly());

        //Then
        assertEquals(result,"OK");
    }

    @Test
    public void testGenerate(){
        //Given
        generator = mock(NumGenerator.class);
        given(generator.generate()).willReturn(6).willReturn(5).willReturn(3);

        //When
        String result1 = counter.getResult(generator.generate());
        String result2 = counter.getResult(generator.generate());
        String result3 = counter.getResult(generator.generate());

        //Then
        assertEquals(result1,"OK");
        assertEquals(result2,"OK");
        assertEquals(result3,"OK");

    }

}
