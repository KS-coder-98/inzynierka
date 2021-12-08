package pl.krzysiek.conferenceroombookingsystem.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysiek.conferenceroombookingsystem.entity.ConferenceRoom;


public interface ConferenceRoomRepository extends JpaRepository<ConferenceRoom, Long> {

    Page<ConferenceRoom> findAll(Specification<ConferenceRoom> roomSpecification, Pageable pageable);

    Page<ConferenceRoom> findAll(Pageable pageable);

    @Transactional
    @Modifying(flushAutomatically = true)
    @Query("update ConferenceRoom c set c.name = ?1, c.description = ?2, c.capacity=?3 where c.id = ?4")
    void setConferenceRoomById(String name, String description, Integer capacity, Long id);

}
