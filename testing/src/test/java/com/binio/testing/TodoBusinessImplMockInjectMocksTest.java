package com.binio.testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by tomasz.biniecki on 06/09/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockInjectMocksTest {

    @Mock
    TodoService todoServiceMock;

    @InjectMocks
    TodoBusinessImpl todoBusinessImpl;

    @Test
    public void testRetrieveTodosRealatedToSpring_usingMock() {
        when(todoServiceMock.retrievieTodos("Dummy")).thenReturn(Arrays.asList("Learn Spring MVC", "Learn to run in Spring", "Learn to sing"));
        //TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock); we can remove this as @InjectMocks takes care of this
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRealatedToSpring("Dummy");
        assertEquals(2, filteredTodos.size());
    }


}