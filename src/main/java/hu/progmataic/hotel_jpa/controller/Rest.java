package hu.progmataic.hotel_jpa.controller;

import hu.progmataic.hotel_jpa.model.Booking;
import hu.progmataic.hotel_jpa.model.Guest;
import hu.progmataic.hotel_jpa.model.Room;
import hu.progmataic.hotel_jpa.service.BookingService;
import hu.progmataic.hotel_jpa.service.GuestService;
import hu.progmataic.hotel_jpa.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/rest")
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

   @GetMapping("/guestsList")
    public List<Guest> showAllGuest(){
        return guestService.getAllGuest();
    }

    @GetMapping("/guestsList/{id}")
    public Guest showGuestById(@PathVariable Integer id){
        return guestService.findGuestById(id);
    }

    @PostMapping("/guestsList")
    public Guest addNewGuest(@RequestBody Guest newGuest){
        return guestService.addNewGuest(newGuest);
    }

    @PutMapping("/guestsList/{id}")
    public Guest updateGuestData(@PathVariable Integer id, @RequestBody Guest guest){
        return guestService.updateGuestData(id, guest);
    }

    @GetMapping("/roomList")
    public List<Room> showAllRooms(){
        return roomService.getAllRoom();
    }

    @PutMapping("/roomList/{id}")
    public Room updateRoom(@PathVariable Integer id, @RequestBody Room room){
        return roomService.updateRoom(id, room);
    }

    @GetMapping("/bookingList")
    public List<Booking> showAllBookings(){
        return bookingService.getAllBooking();
    }

    @GetMapping("/available")
    public List<Room> getAvailableRoom(){
        return roomService.getAllAvailableRooms(LocalDate.of(2023,6,1),
                LocalDate.of(2023,6,30),3);
    }

    @PostMapping("/bookingList")
    public Booking addNewBooking(@RequestBody Booking newBooking){
        return bookingService.createBooking(newBooking);
    }
    @PutMapping("/bookingList/{id}")
    public Booking updateBooking(@PathVariable Integer id, @RequestBody Booking booking){
        return bookingService.updateBooking(id,booking);
    }

    @DeleteMapping("/bookingList/{id}")
    public void deleteBooking (@PathVariable Integer id){
        bookingService.deleteBooking(id);
    }


}
