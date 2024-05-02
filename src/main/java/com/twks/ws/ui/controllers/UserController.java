package com.twks.ws.ui.controllers;


import com.twks.ws.services.UserService;
import com.twks.ws.ui.model.requests.UserDetailsRequest;
import com.twks.ws.ui.model.requests.UpdateUserDetailsRequest;
import com.twks.ws.ui.model.responses.UserRest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users") // localhost:8080/users
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserRest>> getUsers(@RequestParam(value = "page", defaultValue = "1", required = false) int page,
                                         @RequestParam(value = "limit", defaultValue = "10", required = false) int limit,
                                         @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort){
        List<UserRest> listUsers = userService.getUsers(page, limit, sort);
        return new ResponseEntity<>(listUsers, HttpStatus.OK);
    }

    @GetMapping(path = "/{userId}", produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId){
        UserRest ussr = userService.getUser(userId);
        return new ResponseEntity<>(ussr, HttpStatus.OK);
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequest userBody){
        UserRest createdUser = userService.createUser(userBody);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping(
            path = "/{userId}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<UserRest> updateUser(@PathVariable(value = "userId") String userId,
                             @Valid @RequestBody UpdateUserDetailsRequest userBody){
        UserRest updatedUser = userService.updateUser(userId, userBody);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping(
            path = "/{userId}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Void> deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
