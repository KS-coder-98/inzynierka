package pl.krzysiek.conferenceroombookingsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.krzysiek.conferenceroombookingsystem.entity.User;
import pl.krzysiek.conferenceroombookingsystem.exceprion.ErrorMsg;
import pl.krzysiek.conferenceroombookingsystem.exceprion.NotFoundException;
import pl.krzysiek.conferenceroombookingsystem.service.UserService;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> one(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity.ok()::body)
                .orElseThrow(() -> new NotFoundException(ErrorMsg.USER_NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<Page<User>> all(Pageable pageable) {
        return ResponseEntity.ok().body(userService.getAllUsers(pageable));
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        return userService.createUser(user)
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.badRequest().header("Responded", "failed to create user")
                        .body(null));
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return userService.updateUser(user)
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.notFound().build());
    }

}
