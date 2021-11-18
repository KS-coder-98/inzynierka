package pl.krzysiek.conferenceroombookingsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.krzysiek.conferenceroombookingsystem.dto.UserDto;
import pl.krzysiek.conferenceroombookingsystem.entity.User;
import pl.krzysiek.conferenceroombookingsystem.mapper.UserMapper;
import pl.krzysiek.conferenceroombookingsystem.service.UserService;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/{id}")
    public ResponseEntity<User> one(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/byEmail")
    public ResponseEntity<UserDto> oneByEmail(@RequestParam String mail) {
        return userService.getUserByMail(mail)
                .map(oU -> ResponseEntity.ok().body(userMapper.toUserDto(oU)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Page<UserDto>> all(Pageable pageable) {
        return ResponseEntity.ok().body(userService.getAllUsers(pageable).map(userMapper::toUserDto));
    }

    @GetMapping("/hello")
    public ResponseEntity<Boolean> userHandler(@RequestParam String mail, @RequestParam String nick) {
        userService.createUser(mail, nick);
        return ResponseEntity.ok(userService.isAdmin(mail));
    }

    @GetMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return userService.updateUser(user)
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.notFound().build());
    }

}
