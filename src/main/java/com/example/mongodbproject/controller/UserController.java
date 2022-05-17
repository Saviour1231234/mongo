package com.example.mongodbproject.controller;

import com.example.mongodbproject.entity.User;
import com.example.mongodbproject.repository.UserRepository;
import com.example.mongodbproject.response.MessageResponse;
import com.example.mongodbproject.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserController {

    UserService userService;

    MongoTemplate mongoTemplate;


    @GetMapping(value = "/api/users")
    public ResponseEntity<List<User>> findAllUsers() {
        var userServiceAll = userService.findAll();

        return new ResponseEntity<>(userServiceAll, HttpStatus.OK);
    }


    @GetMapping(value = "/api/user/{usersId}")
    public ResponseEntity<Optional<User>> findById(@PathVariable String usersId) {
        var byId = userService.findById(usersId);

        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @PostMapping("/api/users/create")
    public ResponseEntity<User> createUser(@RequestBody User user){

        var insert = mongoTemplate.insert(user);

        return new ResponseEntity<>(insert, HttpStatus.OK);
    }

    @GetMapping(value = "/api/users/find/{filter}")
    public ResponseEntity<User> findBy(@PathVariable String filter, String criteria) {
        var user = userService.findBy(filter, criteria);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "/api/users/find/remove{filter}")
    public ResponseEntity<MessageResponse> findAndRemove(@PathVariable String filter, String criteria) {

        userService.findAllByCriteriaAndRemove(filter, criteria);

        return new ResponseEntity<>(new MessageResponse("User was deleted"), HttpStatus.OK);
    }



}
