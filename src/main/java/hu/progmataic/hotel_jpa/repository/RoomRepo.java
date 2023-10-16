package hu.progmataic.hotel_jpa.repository;

import hu.progmataic.hotel_jpa.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface RoomRepo extends JpaRepository<Room, Integer> {

List<Room> findAllByIdNotInAndMaxCapacityGreaterThanEqual(Collection<Integer> ids, Integer capacity);


}
