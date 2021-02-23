package com.knuspersnack.rest.webservices.todoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Void> saveTodo(@PathVariable String username, @RequestBody Todo todo) {
        Todo createdTodo = todoDataService.save(todo);

        //The aim is to responde to the client with the url of the created accident, therefore we extend the current url
        URI url = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdTodo.getId())
                .toUri();

        //It is common to responde with an URL of the new created object, which is then located in the header
        return ResponseEntity.created(url).build();
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable String username, @PathVariable long id) {
        boolean isSuccessful = todoDataService.deleteById(id);
        return (isSuccessful)
                ? ResponseEntity.ok("Successfully deleted todo with id " + id)
                : ResponseEntity.notFound().build();
    }

}
