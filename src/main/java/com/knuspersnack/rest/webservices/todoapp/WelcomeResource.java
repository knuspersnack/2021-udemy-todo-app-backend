package com.knuspersnack.rest.webservices.todoapp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WelcomeResource {

    @GetMapping("/welcome/message/{username}")
    public ResponseEntity<String> getAllTodos(@PathVariable String username) {
        return ResponseEntity.ok("Welcome to the Todo-App. Here you can create and manage your ToDos quick!");
    }

}
