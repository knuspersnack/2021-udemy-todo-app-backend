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
public class WelcomeResource {

    @GetMapping("/welcome/message/{username}")
    public ResponseEntity<String> getAllTodos(@PathVariable String username) {
        return ResponseEntity.ok("Welcome to the Todo-App. Here you can create and manage your ToDos quick!");
    }

}
