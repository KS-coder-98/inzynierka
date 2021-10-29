package pl.krzysiek.conferenceroombookingsystem.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysiek.conferenceroombookingsystem.entity.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findAll(Pageable pageable);

    @Transactional
    @Modifying(flushAutomatically = true)
    @Query("update User u set u.nick = ?1, u.firstName = ?2, u.lastName = ?3 where u.id = ?4")
    void setUserById(String nick, String firstName, String lastName, Long id);

    boolean existsByEmail(String email);

    boolean existsByNick(String nick);
}
