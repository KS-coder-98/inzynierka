package pl.krzysiek.conferenceroombookingsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.krzysiek.conferenceroombookingsystem.entity.UserContact;
import pl.krzysiek.conferenceroombookingsystem.repository.UserContactRepository;

@RestController
@RequestMapping("user-contact")
@RequiredArgsConstructor
public class UserContactController {

    private final UserContactRepository userContactRepository;

    @PutMapping
    public ResponseEntity<UserContact> updateUserContactById(@RequestBody UserContact userContact){
        userContactRepository.setUserContactById(
                userContact.getCity(),
                userContact.getStreet(),
                userContact.getHouseNumber(),
                userContact.getStreetNumber(),
                userContact.getPostCode(),
                userContact.getPhoneNumber(),
                userContact.getPhoneAreaCode(),
                userContact.getId()
        );
        return userContactRepository.findById(userContact.getId())
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.notFound().build());
    }
}
