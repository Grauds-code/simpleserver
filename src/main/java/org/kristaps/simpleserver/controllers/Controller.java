package org.kristaps.simpleserver.controllers;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.kristaps.simpleserver.models.UserModel;
import org.kristaps.simpleserver.services.ControllerService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")

public class Controller {
    // Rest bus lai ienak izpilda aizsuta un izdzesh.
    // CRUD operacijas - Create, Read, Update, Delete

    // POST - Create (c)
    // GET - Read (r)
    // PUT - Update (u)
    // DELETE - Delete (d)

    private final ControllerService controllerService;

    @PostMapping("/api/v1/users") // Endpoint root: http://localhost:8088/api/v1/users
    public ResponseEntity<Long> createUser(@RequestBody UserModel userModel) {
        return new ResponseEntity<>(controllerService.createUser(userModel), HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/check/{email}") // Endpoint root: http://localhost:8088/api/v1/users/check
    public ResponseEntity<Boolean> checkIfEmailExsists(@PathVariable String email) {
        System.out.println(email);
        boolean emailTru = controllerService.checkEmailExists(email);
        System.out.println(emailTru);

        if (controllerService.checkEmailExists(email)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }

        return new ResponseEntity<>(false, HttpStatus.OK);
    }

}
