package com.binio.testing;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by tomasz.biniecki on 07/09/2017.
 */
public class ListTest {

    @Test
    public void testMockListSizeMethod() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);
        assertEquals(2,listMock.size());
        assertEquals(2,listMock.size());

    }

    @Test
    public void testMockListSizeMethod_multipleValues() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(4).thenReturn(5);
        assertEquals(2,listMock.size());
        assertEquals(4,listMock.size());
        assertEquals(5,listMock.size());

    }

    @Test
    public void testMockListGetMethod() {
        List listMock = mock(List.class);
        //Argument matcher
        when(listMock.get(0)).thenReturn("In28Minutes");
        assertEquals("In28Minutes",listMock.get(0));
        //assertEquals("In28Minutes",listMock.get(1));

    }

    @Test
    public void testMockListGetMethod_anyInt() {
        List listMock = mock(List.class);
        //Argument matcher anyInt()
        when(listMock.get(anyInt())).thenReturn("In28Minutes");
        assertEquals("In28Minutes",listMock.get(0));
        assertEquals("In28Minutes",listMock.get(1));
        assertEquals("In28Minutes",listMock.get(1));

    }

    @Test(expected=RuntimeException.class)
    public void testMockListGetMethod_exception() {
        List listMock = mock(List.class);
        //Argument matcher, exception
        when(listMock.get(0)).thenThrow(new RuntimeException("Zoonk"));
        listMock.get(0);
    }


}
