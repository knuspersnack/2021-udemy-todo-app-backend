package com.knuspersnack.rest.webservices.todoapp;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WelcomeResource {

    @GetMapping("/welcome/message/{username}")
    @ResponseBody
    public String getAllTodos(@PathVariable String username) {
        return "Welcome to the Todo-App. Here you can create and manage your ToDos quick!";
    }

}
