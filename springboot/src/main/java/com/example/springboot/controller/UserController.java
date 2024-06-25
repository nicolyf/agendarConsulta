package com.example.springboot.controller;

import com.example.springboot.dtos.UserRecordDTO;
import com.example.springboot.models.UserModel;
import com.example.springboot.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/cadastrarUsuario")
    public ResponseEntity<UserModel> create(@RequestBody @Valid UserRecordDTO user) {
        var userCreated = this.userService.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<UserModel> get(@RequestParam Integer id) {
        var user = this.userService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PutMapping("/{usuarioId}")
    public ResponseEntity<UserModel> update(@RequestParam Integer id, @RequestBody UserRecordDTO user){
        this.userService.get(id);
        var userUpdated = this.userService.update(user);
        return ResponseEntity.status(HttpStatus.OK).body(userUpdated);
    }

    @DeleteMapping("/{usuarioId}")
    public ResponseEntity delete(@RequestParam Integer id) {
        this.userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
