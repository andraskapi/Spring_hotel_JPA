package hu.progmataic.hotel_jpa.controller;

import hu.progmataic.hotel_jpa.model.Guest;
import hu.progmataic.hotel_jpa.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/guest")
public class GuestController {
    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }
    @GetMapping
    public String getAllGuests(Model model){
        model.addAttribute("guests", guestService.getAllGuest());
        return "guests";
    }
    @GetMapping("/{id}")
    public String getGuestById(@PathVariable("id") Integer id, Model model){
        model.addAttribute("guest", guestService.findGuestById(id));
        return "show-guest";
    }
    @GetMapping("/new")
    public String newGuest(Model model){
        model.addAttribute("guest",new Guest());
        return "new-guest";
    }

    @PostMapping("/new")
    public String newGuest(@ModelAttribute("guest") Guest guest){
        guestService.addNewGuest(guest);

        return "redirect:/guest";
    }

}
