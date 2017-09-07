package com.binio.testing;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * Created by tomasz.biniecki on 07/09/2017.
 */
public class VerifyMethodCall {

    @Test
    public void letsMockListGet_usingBDD() {
        //Given
        TodoService  todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring", "Spring MVC", "Learn to dance");
        given(todoServiceMock.retrievieTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        //When
        todoBusinessImpl.deleteTodosNotRealatedToSpring("Dummy");

        //Then
        verify(todoServiceMock).deleteTodo("Learn to dance");
        verify(todoServiceMock, never()).deleteTodo("Spring MVC");
        //verify(todoServiceMock).deleteTodo("Spring MVC"); this will not pass as delete removes only Spring elements
    }
}
