package com.app.minigame.Controller;

import com.app.minigame.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Operation(description = "Validates user login info")
    @GetMapping("/login/{username}/{password}")
    int login(@PathVariable String username, @PathVariable String password) {
    	return userService.loginValidation(username, password);
    }
}
