package hu.progmataic.hotel_jpa.service;

import hu.progmataic.hotel_jpa.model.Booking;
import hu.progmataic.hotel_jpa.model.Room;
import hu.progmataic.hotel_jpa.repository.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoomService {

    private final RoomRepo roomRepository;
    private final BookingService bookingService;

    @Autowired
    public RoomService(RoomRepo roomRepository, BookingService bookingService) {
        this.roomRepository = roomRepository;

        this.bookingService = bookingService;
    }

    public List<Room> getAllRoom() {
        return roomRepository.findAll();
    }
    public Room getRoomById(Integer id){
        return roomRepository.findById(id).orElse(null);
    }

    public Room updateRoom(Integer id, Room room) {
        Room roomToBeUpdated = roomRepository.findById(id).orElse(null);

        if (room.getMaxCapacity() != null) {
            roomToBeUpdated.setMaxCapacity(room.getMaxCapacity());
        }
        if (room.getPricePerNight() != null) {
            roomToBeUpdated.setPricePerNight(room.getPricePerNight());
        }
        if (room.getHasJakuzzi() != null) {
            roomToBeUpdated.setHasJakuzzi(room.getHasJakuzzi());
        }
        if (room.getHasSauna() != null) {
            roomToBeUpdated.setHasSauna(room.getHasSauna());
        }

        return roomRepository.save(roomToBeUpdated);

    }

    public List<Room> getAllAvailableRooms(LocalDate checkIn, LocalDate checkOut, Integer guestNumber) {
        List<Booking> wrongBookings = bookingService.betweenDates(checkIn,checkOut);
        Set<Integer> wrongRoomId = new HashSet<>();
        for (Booking actual : wrongBookings){
            wrongRoomId.add(actual.getRoom().getId());
        }
        return roomRepository.findAllByIdNotInAndMaxCapacityGreaterThanEqual(wrongRoomId,guestNumber);


    }
}
