package com.dmg.sistema_dmg_backend.auth.web.controller;

import com.dmg.sistema_dmg_backend.auth.persitence.entity.UserEntity;
import com.dmg.sistema_dmg_backend.auth.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user){
        return ResponseEntity.ok(this.userService.createUser(user));
    }

    @PostMapping("/{userId}/roles")
    public ResponseEntity<UserEntity> assignRoles(@PathVariable long userId, @RequestBody Map<String, List<Long>> roleIdsMap){
        List<Long> roleIds = roleIdsMap.get("roleIds");
        UserEntity updatedUser = this.userService.assignRoles(userId, roleIds);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/test")
    @Secured("ROLE_member")
    public String helloGetTest(){
        return "Hello world test";
    }
}
