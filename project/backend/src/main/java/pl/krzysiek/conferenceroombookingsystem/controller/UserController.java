package pl.krzysiek.conferenceroombookingsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.krzysiek.conferenceroombookingsystem.entity.User;
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
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Page<User>> all(Pageable pageable) {
        return ResponseEntity.ok().body(userService.getAllUsers(pageable));
    }

    @GetMapping("/hello")
    public void userHandler(@RequestParam String mail, @RequestParam String nick) {
        userService.createUser(mail, nick);
    }

    @GetMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return userService.updateUser(user)
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.notFound().build());
    }

}
