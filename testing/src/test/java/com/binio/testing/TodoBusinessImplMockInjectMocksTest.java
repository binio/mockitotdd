package com.binio.testing;

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

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

/**
 * Created by tomasz.biniecki on 06/09/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockInjectMocksTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    TodoService todoServiceMock;

    @InjectMocks
    TodoBusinessImpl todoBusinessImpl;

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    @Test
    public void testRetrieveTodosRealatedToSpring_usingMock() {
        when(todoServiceMock.retrievieTodos("Dummy")).thenReturn(Arrays.asList("Learn Spring MVC", "Learn to run in Spring", "Learn to sing"));
        //TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock); we can remove this as @InjectMocks takes care of this
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRealatedToSpring("Dummy");
        assertEquals(2, filteredTodos.size());
    }

    @Test
    public void letsDeleteTodos_usingBDDArgCaptureMultipleTimes() {
        //We can remove argumentCAptor as @Captor annotation will take care of
        //ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);


        //Given
        List<String> todos = Arrays.asList("Learn Spring", "Spring MVC", "Learn to dance", "Learn to rock and roll");
        given(todoServiceMock.retrievieTodos("Dummy")).willReturn(todos);

        //When
        todoBusinessImpl.deleteTodosNotRealatedToSpring("Dummy");

        //Then
        then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getAllValues().size(),is(2));
    }


}