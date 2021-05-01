package com.allo.hruser.resources;

import com.allo.hruser.entities.User;
import com.allo.hruser.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/users")
public class UserResource {

    private final UserRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        return ResponseEntity.ok(repository.findById(id).orElseThrow());
    }

    @GetMapping("/search")
    public ResponseEntity<User> findById(@RequestParam String email){
        return ResponseEntity.ok(repository.findByEmail(email));
    }
}
