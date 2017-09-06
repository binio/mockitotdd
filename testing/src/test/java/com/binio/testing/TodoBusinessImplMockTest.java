package com.binio.testing;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by tomasz.biniecki on 06/09/2017.
 */
public class TodoBusinessImplMockTest {

    @Test
    public void testRetrieveTodosRealatedToSpring_usingMock() {
    TodoService todoServiceMock = mock(TodoService.class);
    when(todoServiceMock.retrievieTodos("Dummy")).thenReturn(Arrays.asList("Learn Spring MVC", "Learn to run in Spring", "Learn to sing"));
    TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
    List<String> filteredTodos = todoBusinessImpl.retrieveTodosRealatedToSpring("Dummy");
    assertEquals(2,filteredTodos.size());
    }
}