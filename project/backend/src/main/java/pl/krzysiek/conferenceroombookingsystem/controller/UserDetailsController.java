package pl.krzysiek.conferenceroombookingsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.krzysiek.conferenceroombookingsystem.entity.UserDetails;
import pl.krzysiek.conferenceroombookingsystem.repository.UserDetailsRepository;

@RestController
@RequestMapping("user-details")
@RequiredArgsConstructor
public class UserDetailsController {

    private final UserDetailsRepository userDetailsRepository;

    @GetMapping
    public ResponseEntity<UserDetails> updateUserDetailsById(@RequestBody UserDetails userDetails) {
        userDetailsRepository.setUserDetailsById(userDetails.getTypeOfMembers(), userDetails.getDateOfBirth(),
                userDetails.getId());
        return userDetailsRepository.findById(userDetails.getId())
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.notFound().build());
    }
}
