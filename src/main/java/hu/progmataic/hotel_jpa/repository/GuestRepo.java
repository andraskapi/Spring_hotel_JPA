package hu.progmataic.hotel_jpa.repository;

import hu.progmataic.hotel_jpa.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepo extends JpaRepository<Guest, Integer> {
}
