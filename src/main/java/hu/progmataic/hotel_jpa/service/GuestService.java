package hu.progmataic.hotel_jpa.service;

import hu.progmataic.hotel_jpa.model.Guest;
import hu.progmataic.hotel_jpa.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> getAllGuest() {
        return guestRepository.findAll();
    }

    public Guest addNewGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    public Guest findGuestById(Integer id) {
        return guestRepository.findById(id).orElse(null);
    }

    public Guest updateGuestData(Integer id, Guest guest) {
        Guest guestToBeUpdated = findGuestById(id);

        if (guest.getTitle() != null) {
            guestToBeUpdated.setTitle(guest.getTitle());
        }
        if (guest.getFamily_name() != null) {
            guestToBeUpdated.setFamily_name(guest.getFamily_name());
        }
        if(guest.getFirst_name() != null) {
            guestToBeUpdated.setFirst_name(guest.getFirst_name());
        }
        if (guest.getPlace_of_birth() != null) {
            guestToBeUpdated.setPlace_of_birth(guest.getPlace_of_birth());
        }
        if (guest.getDate_of_birth() != null) {
            guestToBeUpdated.setDate_of_birth(guest.getDate_of_birth());
        }
        if (guest.getIdentification_number() != null) {
            guestToBeUpdated.setIdentification_number(guest.getIdentification_number());
        }
        if (guest.getEmail() != null) {
            guestToBeUpdated.setEmail(guest.getEmail());
        }

       return guestRepository.save(guestToBeUpdated);




    }


}
