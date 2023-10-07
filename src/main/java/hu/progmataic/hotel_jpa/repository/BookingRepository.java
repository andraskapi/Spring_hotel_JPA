package hu.progmataic.hotel_jpa.repository;

import hu.progmataic.hotel_jpa.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
