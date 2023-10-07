package hu.progmataic.hotel_jpa.controller;

import hu.progmataic.hotel_jpa.model.Booking;
import hu.progmataic.hotel_jpa.model.Guest;
import hu.progmataic.hotel_jpa.model.Room;
import hu.progmataic.hotel_jpa.service.BookingService;
import hu.progmataic.hotel_jpa.service.GuestService;
import hu.progmataic.hotel_jpa.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Rest {

    private final GuestService guestService;

    private final RoomService roomService;
    private final BookingService bookingService;

    @Autowired
    public Rest(GuestService guestService, RoomService roomService, BookingService bookingService) {
        this.guestService = guestService;
        this.roomService = roomService;
        this.bookingService = bookingService;
    }

   @GetMapping("/guests")
    public List<Guest> showAllGuest(){
        return guestService.getAllGuest();
    }

    @GetMapping("/guests/{id}")
    public Guest showGuestById(@PathVariable Integer id){
        return guestService.findGuestById(id);
    }

    @PostMapping("/guests/{id}")
    public Guest updateGuestData(@PathVariable Integer id, @RequestBody Guest guest){
        return guestService.updateGuestData(id, guest);
    }

    @GetMapping("/rooms")
    public List<Room> showAllRooms(){
        return roomService.getAllRoom();
    }

    @GetMapping("/bookings")
    public List<Booking> showAllBookings(){
        return bookingService.getAllBooking();
    }

    @PostMapping("/rooms/{id}")
    public Room updateRoom(@PathVariable Integer id, @RequestBody Room room){
        return roomService.updateRoom(id, room);
    }


}
