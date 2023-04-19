package org.springframework.samples.petclinic.booking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking,Integer>{
    
    @Query("select count(b) from Booking b where b.pet.owner.user.username = ?1 and month(b.startDate)=?2")
    Integer countBookingsByOwner(String owner,Integer month);
}
