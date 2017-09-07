package com.binio.testing;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

/**
 * Created by tomasz.biniecki on 07/09/2017.
 */
public class GivenWhenThen {

    @Test
    public void testRetrieveTodosRelatedToSpring_usingBDD() {
        //Given
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Lerarn Spring", "Spring MVC", "Learn to dance");
        given(todoServiceMock.retrievieTodos("Dummy")).willReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        //When
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRealatedToSpring("Dummy");

        //Then
        //assertEquals(2,filteredTodos.size()); changing assets from JUnit to BDD style
        assertThat(filteredTodos.size(),is(2));
    }
}
