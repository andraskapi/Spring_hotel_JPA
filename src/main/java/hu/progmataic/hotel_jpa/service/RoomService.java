package hu.progmataic.hotel_jpa.service;

import hu.progmataic.hotel_jpa.model.Room;
import hu.progmataic.hotel_jpa.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRoom() {
        return roomRepository.findAll();
    }

    public Room updateRoom(Integer id, Room room) {
        Room roomToBeUpdated = roomRepository.findById(id).orElse(null);

        if (room.getMax_capacity() != null) {
            roomToBeUpdated.setMax_capacity(room.getMax_capacity());
        }
        if (room.getPrice_per_night() != null) {
            roomToBeUpdated.setPrice_per_night(room.getPrice_per_night());
        }
        if (room.getHas_jakuzzi() != null) {
            roomToBeUpdated.setHas_jakuzzi(room.getHas_jakuzzi());
        }
        if (room.getHas_sauna() != null) {
            roomToBeUpdated.setHas_sauna(room.getHas_sauna());
        }

        return roomRepository.save(roomToBeUpdated);

    }
}
