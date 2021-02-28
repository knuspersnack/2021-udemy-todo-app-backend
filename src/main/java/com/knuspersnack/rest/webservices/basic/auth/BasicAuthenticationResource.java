package com.knuspersnack.rest.webservices.basic.auth;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class BasicAuthenticationResource {

    @GetMapping("/basicauth")
    @ResponseBody
    public AuthenticationBean getAllTodos(@PathVariable String username) {
        return new AuthenticationBean("Your are authenticated");
    }

}
