package com.binio.testing;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.BDDMockito.*;

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

    @Test
    public void letsDeleteTodos_usingBDDArgCapture() {
        //Declare argument captor
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        //Define argumentCaptor on method call
        //Check it


        //Given
        TodoService  todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring", "Spring MVC", "Learn to dance");
        given(todoServiceMock.retrievieTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        //When
        todoBusinessImpl.deleteTodosNotRealatedToSpring("Dummy");

        //Then
        then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getValue(),is("Learn to dance"));
    }

    @Test
    public void letsDeleteTodos_usingBDDArgCaptureMultipleTimes() {
        //Declare argument captor
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        //Define argumentCaptor on method call
        //Check it


        //Given
        TodoService  todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring", "Spring MVC", "Learn to dance", "Learn to rock and roll");
        given(todoServiceMock.retrievieTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        //When
        todoBusinessImpl.deleteTodosNotRealatedToSpring("Dummy");

        //Then
        then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getAllValues().size(),is(2));
    }

    @Test
    public void letsDeleteTodos_usingBDD() {
        //Given
        TodoService  todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring", "Spring MVC", "Learn to dance");
        given(todoServiceMock.retrievieTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        //When
        todoBusinessImpl.deleteTodosNotRealatedToSpring("Dummy");

        //Then
        then(todoServiceMock).should().deleteTodo("Learn to dance");
        then(todoServiceMock).should(never()).deleteTodo("Spring MVC");
    }
}
