package com.binio.testing;

import java.util.List;

/**
 * Created by tomasz.biniecki on 06/09/2017.
 */
    //1. create serrvice stub
    //2. test businesImpl

public interface TodoService {

    public List<String> retrievieTodos(String user);
    public void deleteTodo(String todo);
}
