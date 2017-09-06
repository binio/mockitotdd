package com.binio.testing;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by tomasz.biniecki on 06/09/2017.
 */
public class TodoBusinessImplStubTest {

    @Test
    public void testRetrieveTodosRealatedToSpring_usingStub() {
    TodoService todoServiceStub = new TodoServiceStub();
    TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
    List<String> filteredTodos = todoBusinessImpl.retrieveTodosRealatedToSpring("Dummy");
    assertEquals(2,filteredTodos.size());
    }
}