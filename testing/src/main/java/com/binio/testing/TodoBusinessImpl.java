package com.binio.testing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomasz.biniecki on 06/09/2017.
 */
//TodoBusinessImpl SUT
//TodoService - dependency

public class TodoBusinessImpl {
    private TodoService todoService;

    public TodoBusinessImpl(TodoService service) {
        super();
        todoService =  service;
    }

    public List<String> retrieveTodosRealatedToSpring(String user) {
        List<String> filteredTodos = new ArrayList<String>();
        List<String> todos = todoService.retrievieTodos(user);

        for(String todo:todos){
            if(todo.contains("Spring")){
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public void deleteTodosNotRealatedToSpring(String user) {
        List<String> todos = todoService.retrievieTodos(user);

        for(String todo:todos){
            if(!todo.contains("Spring")){
                todoService.deleteTodo(todo);
            }
        }
    }

}
