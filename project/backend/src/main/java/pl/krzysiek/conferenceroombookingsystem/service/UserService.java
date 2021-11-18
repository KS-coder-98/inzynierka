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

    public void createUser(String mail, String nick) {
        if (userRepository.existsByEmail(mail) && userRepository.existsByNick(nick)) {
            return;
        }
        var user = new User();
        user.setEmail(mail);
        user.setNick(nick);
        UserContact userContact = new UserContact();
        userContactRepository.save(userContact);
        user.setUserContact(userContact);

        UserDetails userDetails = new UserDetails();
        userDetails.setTypeOfMembers(User.NORMAL_USER);
        userDetailsRepository.save(userDetails);
        user.setUserDetails(userDetails);
        user.setId(null);
        userRepository.save(user);
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

    public boolean isAdmin(String mail) {
        Optional<User> userRepositoryByEmail = userRepository.findByEmail(mail);
        return userRepositoryByEmail.filter(user -> User.ADMIN_USER.equals(
                        user.getUserDetails().getTypeOfMembers()))
                .isPresent();
    }

    public Optional<User> getUserByMail(String mail) {
        return userRepository.findByEmail(mail);
    }

}
