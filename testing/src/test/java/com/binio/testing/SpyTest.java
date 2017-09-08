package com.binio.testing;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by tomasz.biniecki on 08/09/2017.
 */
public class SpyTest {

    @Test
    public void test() {
        List arrayListSpy = spy(ArrayList.class);
        assertEquals(0,arrayListSpy.size());
        arrayListSpy.add("Dummy");
        assertEquals(1,arrayListSpy.size());
        arrayListSpy.remove("Dummy");
        assertEquals(0,arrayListSpy.size());

        //--All three lines below mean the same
        //stub(arrayListSpy.size()).toReturn(5);
        //Mockito.doReturn(5).when(arrayListSpy).size();
        //when(arrayListSpy.size()).thenReturn(5);

        when(arrayListSpy.size()).thenReturn(5);

        assertEquals(5,arrayListSpy.size());

    }
}
