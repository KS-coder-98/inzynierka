package pl.krzysiek.conferenceroombookingsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.krzysiek.conferenceroombookingsystem.entity.User;
import pl.krzysiek.conferenceroombookingsystem.entity.UserContact;
import pl.krzysiek.conferenceroombookingsystem.entity.UserDetails;
import pl.krzysiek.conferenceroombookingsystem.repository.UserContactRepository;
import pl.krzysiek.conferenceroombookingsystem.repository.UserDetailsRepository;
import pl.krzysiek.conferenceroombookingsystem.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserContactRepository userContactRepository;
    private final UserDetailsRepository userDetailsRepository;

    public Optional<User> createUser(User user) {
        if (user.isValid()) {
            if (userRepository.existsByEmail(user.getEmail()) && userRepository.existsByNick(user.getNick())) {
                return Optional.empty();
            }
            UserContact userContact = new UserContact();
            userContactRepository.save(userContact);
            user.setUserContact(userContact);

            UserDetails userDetails = new UserDetails();
            userDetailsRepository.save(userDetails);
            user.setUserDetails(userDetails);
            user.setId(null);
            return Optional.of(userRepository.save(user));
        }
        return Optional.empty();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public Optional<User> updateUser(User user) {
        userRepository.setUserById(user.getNick(), user.getFirstName(), user.getLastName(), user.getId());
        return userRepository.findById(user.getId());
    }
}
