package pl.krzysiek.conferenceroombookingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysiek.conferenceroombookingsystem.entity.UserContact;

public interface UserContactRepository extends JpaRepository<UserContact, Long> {

    @Transactional
    @Modifying(flushAutomatically = true)
    @Query("update UserContact c set c.city=?1, c.street=?2, c.houseNumber=?3, c.streetNumber=?4, c.postCode=?5, "
            + "c.phoneNumber=?6, c.phoneAreaCode=?7, c.email=?8 where c.id=?9")
    void setUserContactById(String city, String street, int houseNum, int streetNum, String postCode,
                            String phoneNumber, String phoneAreaCode, String email, Long id);
}
