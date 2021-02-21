package com.knuspersnack.rest.webservices.todoapp;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ToDoService {

    private static List<Todo> todos = new ArrayList();
    private static int idCounter = 0;

    static {
        todos.add(new Todo(++idCounter, "in28minutes", "Learn to danace", LocalDate.of(2020, 02, 01), false));
        todos.add(new Todo(++idCounter, "in28minutes", "Learn to Microservices", LocalDate.of(2019, 03, 01), true));
        todos.add(new Todo(++idCounter, "in28minutes", "Learn to Angular", LocalDate.of(2020, 04, 01), false));
    }

    public List<Todo> findAll() {
        return todos;
    }

    public boolean deleteById(long id) {
        Todo todo = findById(id);
        if(todo != null) {
            return todos.remove(todo);
        }
        return false;
    }

    public Todo findById(long id) {
        for(Todo todo:todos) {
            if(todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

}
