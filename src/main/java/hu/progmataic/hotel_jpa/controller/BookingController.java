package hu.progmataic.hotel_jpa.controller;

import hu.progmataic.hotel_jpa.model.Booking;
import hu.progmataic.hotel_jpa.service.BookingService;
import hu.progmataic.hotel_jpa.service.GuestService;
import hu.progmataic.hotel_jpa.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;
    private final RoomService roomService;

    private final GuestService guestService;

    @Autowired
    public BookingController(BookingService bookingService, RoomService roomService, GuestService guestService) {
        this.bookingService = bookingService;
        this.roomService = roomService;
        this.guestService = guestService;
    }

    @GetMapping()
    public String getBookings(Model model) {
        model.addAttribute("bookings", bookingService.getAllBooking());

        return "bookings";
    }

    @GetMapping("/new-date")
    public String createBookingDate(Model model) {
        model.addAttribute("booking", new Booking());
        return "new-booking-date";
    }

    @GetMapping("/new")
    public String createBooking(Model model, @ModelAttribute("booking") Booking booking) {
        System.out.println(booking);
        model.addAttribute("booking", booking);
        model.addAttribute("rooms", roomService.getAllAvailableRooms(
                booking.getCheckIn(),
                booking.getCheckOut(),
                booking.getNumberOfGuest()));
        model.addAttribute("guests", guestService.getAllGuest());


        return "new-booking";
    }

    @PostMapping("/new")
    public String createBooking (@ModelAttribute("booking") Booking booking){
        bookingService.createBooking(booking);
        return "redirect:/home";
    }

    @PostMapping ("/delete/{id}")
    public String deletBooking(@PathVariable("id") Integer id){
        bookingService.deleteBooking(id);
        return "redirect:/bookings";
    }



}
