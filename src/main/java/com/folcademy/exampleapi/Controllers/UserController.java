package com.folcademy.exampleapi.Controllers;

import com.folcademy.exampleapi.Models.Dtos.UserAddDTO;
import com.folcademy.exampleapi.Models.Dtos.UserEditDTO;
import com.folcademy.exampleapi.Models.Dtos.UserReadDTO;
import com.folcademy.exampleapi.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserReadDTO>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }
    @PostMapping("/add")
    public ResponseEntity<UserReadDTO> add(@RequestBody UserAddDTO userAddDTO){
        return ResponseEntity.ok(userService.add(userAddDTO));
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserReadDTO> findById(@PathVariable Integer userId){
        return ResponseEntity.ok(userService.findById(userId));
    }
    @PutMapping("/modify/{userId}")
    public ResponseEntity<UserReadDTO> edit(
            @PathVariable Integer userId,
            @RequestBody UserEditDTO user){
        return ResponseEntity.ok(userService.edit(userId, user));
    }
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<UserReadDTO> deleteById(@PathVariable Integer userId){
        return ResponseEntity.ok(userService.deleteById(userId));
    }
}
