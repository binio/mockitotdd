package com.binio.testing;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tomasz.biniecki on 06/09/2017.
 */
public class TodoServiceStub implements TodoService {
    public List<String> retrievieTodos(String user) {
        return Arrays.asList("Learn Spring MVC", "Learn to run in Spring", "Learn to sing");
    }

    public void deleteTodo(String todo) {

    }
}
