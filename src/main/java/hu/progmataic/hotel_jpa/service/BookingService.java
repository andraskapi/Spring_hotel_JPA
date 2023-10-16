package hu.progmataic.hotel_jpa.service;

import hu.progmataic.hotel_jpa.model.Booking;
import hu.progmataic.hotel_jpa.repository.BookingRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {
    private final BookingRepo bookingRepository;

    @Autowired
    public BookingService(BookingRepo bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBooking() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Integer id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Transactional
    public void deleteBooking(Integer id) {
        bookingRepository.removeBookingById(id);
    }

    public Booking updateBooking(Integer id, Booking booking) {

        Booking bookingToBeUpdated = getBookingById(id);

        if (booking.getRoom() != null) {
            bookingToBeUpdated.setRoom(booking.getRoom());
        }
        if (booking.getGuest() != null) {
            bookingToBeUpdated.setGuest(booking.getGuest());
        }
        if (booking.getCheckIn() != null) {
            bookingToBeUpdated.setCheckIn(booking.getCheckIn());
        }
        if (booking.getCheckOut() != null) {
            bookingToBeUpdated.setCheckOut(booking.getCheckOut());
        }
        if (booking.getNumberOfGuest() != null) {
            bookingToBeUpdated.setNumberOfGuest(booking.getNumberOfGuest());
        }

        return bookingRepository.save(bookingToBeUpdated);


    }

    public List<Booking> betweenDates(LocalDate checkIn, LocalDate checkOut) {
        return bookingRepository.findAllByCheckInIsBetweenOrCheckOutIsBetween(checkIn, checkOut, checkIn, checkOut);


    }


}
