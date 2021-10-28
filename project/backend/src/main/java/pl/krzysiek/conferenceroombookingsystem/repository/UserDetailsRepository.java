package pl.krzysiek.conferenceroombookingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysiek.conferenceroombookingsystem.entity.UserDetails;

import java.time.LocalDate;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

    @Transactional
    @Modifying(flushAutomatically = true)
    @Query("update UserDetails c set c.typeOfMembers = ?1, c.dateOfBirth = ?2 where c.id = ?3")
    void setUserDetailsById(String typeOdMembers, LocalDate localDate ,Long id);

}
