package com.binio.powermock;

import com.binio.testing.TodoBusinessImpl;
import com.binio.testing.TodoService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

/**
 * Created by tomasz.biniecki on 06/09/2017.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UtilityClass.class)
public class MockingStaticMethodTest {

    //Runs specific runner
    //which class have static method
    //Mock
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    Dependency dependency;

    @InjectMocks
    SystemUnderTest systemUnderTest;

    @Test
    public void testDependencyStaticMethod() {
        List<Integer> stats = Arrays.asList(1,2,3);
        when(dependency.retrieveAllStats()).thenReturn(stats);
        PowerMockito.mockStatic(UtilityClass.class);
        when(UtilityClass.staticMethod(6)).thenReturn(150);
        int result = systemUnderTest.methodCallingAStaticMethod();
        assertEquals(150, result);
        PowerMockito.verifyStatic();
        UtilityClass.staticMethod(6);
    }



}