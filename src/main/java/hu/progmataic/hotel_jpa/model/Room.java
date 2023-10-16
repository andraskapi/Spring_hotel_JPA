package hu.progmataic.hotel_jpa.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (name = "room_number")
    private Integer roomNumber;
    @Column (name = "max_capacity")
    private Integer maxCapacity;
    @Column (name = "price_per_night")
    private Integer pricePerNight;
    @Column (name = "has_jakuzzi")
    private Boolean hasJakuzzi;
    @Column (name = "has_sauna")
    private Boolean hasSauna;

    @OneToMany(mappedBy = "room")
    @JsonBackReference
    private List<Booking> bookingList;

    public Room(Integer id, Integer roomNumber, Integer maxCapacity, Integer pricePerNight, Boolean hasJakuzzi, Boolean hasSauna, List<Booking> bookingList) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.maxCapacity = maxCapacity;
        this.pricePerNight = pricePerNight;
        this.hasJakuzzi = hasJakuzzi;
        this.hasSauna = hasSauna;
        this.bookingList = bookingList;
    }

    public Room() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Integer getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Integer pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public Boolean getHasJakuzzi() {
        return hasJakuzzi;
    }

    public void setHasJakuzzi(Boolean hasJakuzzi) {
        this.hasJakuzzi = hasJakuzzi;
    }

    public Boolean getHasSauna() {
        return hasSauna;
    }

    public void setHasSauna(Boolean hasSauna) {
        this.hasSauna = hasSauna;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNumber=" + roomNumber +
                ", maxCapacity=" + maxCapacity +
                ", pricePerNight=" + pricePerNight +
                ", hasJakuzzi=" + hasJakuzzi +
                ", hasSauna=" + hasSauna +
                ", bookingList=" + bookingList +
                '}';
    }
}
