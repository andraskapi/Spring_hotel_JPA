package hu.progmataic.hotel_jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Booking {
    @Id
    private Integer id;
    private Integer room_id;
    private Integer guest_id;
    private Date check_in;
    private Date check_out;
    private Integer number_of_guest;

    // fildnek felvenni, hogy hany fore foglalt
    // many to one booking guest booking room

    public Booking(Integer id, Integer room_id, Integer guest_id, Date check_in, Date check_out, Integer number_of_guest) {
        this.id = id;
        this.room_id = room_id;
        this.guest_id = guest_id;
        this.check_in = check_in;
        this.check_out = check_out;
        this.number_of_guest = number_of_guest;
    }

    public Booking() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public Integer getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(Integer guest_id) {
        this.guest_id = guest_id;
    }

    public Date getCheck_in() {
        return check_in;
    }

    public void setCheck_in(Date check_in) {
        this.check_in = check_in;
    }

    public Date getCheck_out() {
        return check_out;
    }

    public void setCheck_out(Date check_out) {
        this.check_out = check_out;
    }

    public Integer getNumber_of_guest() {
        return number_of_guest;
    }

    public void setNumber_of_guest(Integer number_of_guest) {
        this.number_of_guest = number_of_guest;
    }
}
