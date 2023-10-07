package hu.progmataic.hotel_jpa.service;

import hu.progmataic.hotel_jpa.model.Booking;
import hu.progmataic.hotel_jpa.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

@Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBooking(){
        return bookingRepository.findAll();
    }

    public Booking createBooking (Booking booking){
        return bookingRepository.save(booking);
    }

    public void deleteBooking (Integer id){
        bookingRepository.deleteById(id);
    }

    public Booking updateBooking(Integer id, Booking booking){

    Booking bookingToBeUpdated = bookingRepository.findById(id).get();

    if (booking.getRoom_id() != null){
        bookingToBeUpdated.setRoom_id(booking.getRoom_id());
    }
    if (booking.getGuest_id() != null){
        bookingToBeUpdated.setGuest_id(booking.getGuest_id());
    }
    if (booking.getCheck_in() != null){
        bookingToBeUpdated.setCheck_in(booking.getCheck_in());
    }
    if (booking.getCheck_out() != null){
        bookingToBeUpdated.setCheck_out(booking.getCheck_out());
    }
    if (booking.getNumber_of_guest() != null){
        bookingToBeUpdated.setNumber_of_guest(booking.getNumber_of_guest());
    }

    return bookingRepository.save(bookingToBeUpdated);


    }


}
