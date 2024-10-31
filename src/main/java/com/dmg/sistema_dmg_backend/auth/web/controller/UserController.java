package com.dmg.sistema_dmg_backend.auth.web.controller;

import com.dmg.sistema_dmg_backend.auth.persitence.entity.UserEntity;
import com.dmg.sistema_dmg_backend.auth.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAll() {
        return ResponseEntity.ok(this.userService.getAll());
    }

    @GetMapping("/test")
    @Secured("ROLE_member")
    public String helloGetTest(){
        return "Hello world test";
    }
}
