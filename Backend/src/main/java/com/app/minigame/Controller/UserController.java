package com.app.minigame.Controller;

import com.app.minigame.Model.Users;
import com.app.minigame.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Users", description = "Operations pertaining to players login information")
public class UserController {

    @Autowired
    private UserService userService;

    private final Logger log = LoggerFactory.getLogger(UserController.class);

    @Operation(description = "Gets a list of all users in the database")
    @RequestMapping(method= RequestMethod.GET, path = "/usersall")
    List<Users> getUsers(){
        log.info("Entered getUser in UserController");
        return userService.getUsers();

    }

    @Operation(description = "Gets the user information of the user with the given id")
    @GetMapping("/userbyid/{id}")
    Users getUserById(@PathVariable Integer id){
        log.info("Entered getUserById in UserController");
        return userService.getUserById(id);
    }

    @Operation(description = "Gets the user information of the user with the given username")
    @GetMapping("/users/{username}")
    Users getUserById(@PathVariable String username){
        return userService.getUserByUsername(username);
    }


    @Operation(description = "Creates a new user")
    @PostMapping("/new/{username}/{password}")
    Users createUser(@PathVariable String username, @PathVariable String password){
        return userService.createUser(username,password);

    }

    @Operation(description = "Deletes a user with the given username and password")
    @DeleteMapping("/delete/{username}/{password}")
    Users deleteUser(@PathVariable String username, @PathVariable String password){
        return userService.deleteUser(username, password);
    }

    //doesn't work
    @Operation(description = "Updates a user username")
    @PutMapping("/update/{id}/{newusername}/{password}")
    void updateUsername(@PathVariable Integer id, @PathVariable String newusername, @PathVariable String password){
        Users u = new Users(newusername,password);
        userService.updateUsername(id, u);
    }


//    @Operation(description = "Validates user login info")
//    @GetMapping("/login/{username}/{password}")
//    int login(@PathVariable String username, @PathVariable String password) {
//        return userService.loginValidation(username, password);
//    }


}
