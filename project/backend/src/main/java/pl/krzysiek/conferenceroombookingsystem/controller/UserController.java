package pl.krzysiek.conferenceroombookingsystem.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.krzysiek.conferenceroombookingsystem.entity.User;
import pl.krzysiek.conferenceroombookingsystem.entity.UserContact;
import pl.krzysiek.conferenceroombookingsystem.entity.UserDetails;
import pl.krzysiek.conferenceroombookingsystem.repository.UserContactRepository;
import pl.krzysiek.conferenceroombookingsystem.repository.UserDetailsRepository;
import pl.krzysiek.conferenceroombookingsystem.repository.UserRepository;

import java.util.Optional;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserContactRepository userContactRepository;
    private final UserDetailsRepository userDetailsRepository;

    @GetMapping("/{id}")
    public ResponseEntity<User> one(@PathVariable Long id){
        return userRepository.findById(id)
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Page<User>> all(Pageable pageable){
        var page = userRepository.findAll(pageable);
        return ResponseEntity.ok().body(page);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){

        UserContact userContact = new UserContact();
        userContactRepository.save(userContact);
        user.setUserContact(userContact);

        UserDetails userDetails = new UserDetails();
        userDetailsRepository.save(userDetails);
        user.setUserDetails(userDetails);

        User user1 = userRepository.save(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
        userRepository.setUserById(user.getNick(), user.getFirstName(), user.getLastName(), user.getId());
        return userRepository.findById(user.getId())
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        boolean optionalUserPresent = optionalUser.isPresent();
        if ( optionalUserPresent ){
            userRepository.deleteById(id);
            return ResponseEntity.ok().body(null);
        }
        return ResponseEntity.notFound().build();
    }
}
