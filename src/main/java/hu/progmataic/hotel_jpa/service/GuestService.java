package hu.progmataic.hotel_jpa.service;

import hu.progmataic.hotel_jpa.model.Guest;
import hu.progmataic.hotel_jpa.repository.GuestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    private final GuestRepo guestRepository;

    @Autowired
    public GuestService(GuestRepo guestRepository) {
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
        if (guest.getLastName() != null) {
            guestToBeUpdated.setLastName(guest.getLastName());
        }
        if(guest.getFirstName() != null) {
            guestToBeUpdated.setFirstName(guest.getFirstName());
        }
        if (guest.getPlaceOfBirth() != null) {
            guestToBeUpdated.setPlaceOfBirth(guest.getPlaceOfBirth());
        }
        if (guest.getDateOfBirth() != null) {
            guestToBeUpdated.setDateOfBirth(guest.getDateOfBirth());
        }
        if (guest.getIdentificationNumber() != null) {
            guestToBeUpdated.setIdentificationNumber(guest.getIdentificationNumber());
        }
        if (guest.getEmail() != null) {
            guestToBeUpdated.setEmail(guest.getEmail());
        }

       return guestRepository.save(guestToBeUpdated);




    }


}
