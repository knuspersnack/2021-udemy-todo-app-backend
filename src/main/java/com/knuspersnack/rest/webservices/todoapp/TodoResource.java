package com.knuspersnack.rest.webservices.todoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoResource {

    @Autowired
    private TodoDataService todoDataService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return todoDataService.findAll();
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id) {
        return todoDataService.findById(id);
    }

    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username,
                                           @PathVariable long id, @RequestBody Todo todo) {
        Todo updatedTodo = todoDataService.save(todo);
        return new ResponseEntity<Todo>(updatedTodo, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/todos/{id}")
    public Todo saveTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo) {
        Todo save = todoDataService.save(todo);
        return todoDataService.save(todo);
    }



    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable String username, @PathVariable long id) {
        boolean isSuccessful = todoDataService.deleteById(id);
        return (isSuccessful)
                ? ResponseEntity.ok("Successfully deleted todo with id " + id)
                : ResponseEntity.notFound().build();
    }

}
