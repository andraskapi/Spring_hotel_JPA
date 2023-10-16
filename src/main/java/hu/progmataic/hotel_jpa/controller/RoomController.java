package hu.progmataic.hotel_jpa.controller;

import hu.progmataic.hotel_jpa.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public String getAllRooms(Model model){
        model.addAttribute("rooms", roomService.getAllRoom());
        return "rooms";
    }
    @GetMapping("/{id}")
    public String getRoomById(@PathVariable("id") Integer id, Model model){
        model.addAttribute("room",roomService.getRoomById(id));
        return "show-room";
    }
}
