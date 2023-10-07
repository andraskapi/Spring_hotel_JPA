package hu.progmataic.hotel_jpa.repository;

import hu.progmataic.hotel_jpa.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
}
