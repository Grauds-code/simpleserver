package org.kristaps.simpleserver.controllers;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

import org.kristaps.simpleserver.models.UserModel;
import org.kristaps.simpleserver.services.ControllerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequiredArgsConstructor

public class Controller {
    // Rest bus lai ienak izpilda aizsuta un izdzesh.
    // CRUD operacijas - Create, Read, Update, Delete

    // POST - Create (c)
    // GET - Read (r)
    // PUT - Update (u)
    // DELETE - Delete (d)

    private final ControllerService controllerService;

    @GetMapping("/api/v1/users") // Endpoint root: http://localhost:8080/api/v1/users
    public ArrayList<UserModel> getUsers() {
        return controllerService.getUsers();
    }

    @GetMapping("/api/v1/user/{id}") // Endpoint root: http://localhost:8080//api/v1/user/{id}
    public UserModel getUser(@PathVariable Long id) {
        return controllerService.getUser(id);
    }
}
