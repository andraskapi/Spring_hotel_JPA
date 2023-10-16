package hu.progmataic.hotel_jpa.repository;

import hu.progmataic.hotel_jpa.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {

    List<Booking> findAllByCheckInIsBetweenOrCheckOutIsBetween(LocalDate checkIn, LocalDate checkOut,LocalDate checkIn2, LocalDate checkOut2);
    void removeBookingById(Integer id);


}
