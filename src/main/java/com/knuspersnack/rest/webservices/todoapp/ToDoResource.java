package com.knuspersnack.rest.webservices.todoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ToDoResource {

    @Autowired
    private ToDoService toDoService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return toDoService.findAll();
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable String username, @PathVariable long id) {
        boolean isSuccessful = toDoService.deleteById(id);
        return (isSuccessful)
                ? ResponseEntity.ok("Successfully deleted todo with id " + id)
                : ResponseEntity.notFound().build();
    }

}
