package hu.progmataic.hotel_jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Room {

    @Id
    private Integer id;
    private Integer max_capacity;
    private Integer price_per_night;
    private Boolean has_jakuzzi;
    private Boolean has_sauna;

    public Room(Integer id, Integer max_capacity, Integer price_per_night, Boolean has_jakuzzi, Boolean has_sauna) {
        this.id = id;
        this.max_capacity = max_capacity;
        this.price_per_night = price_per_night;
        this.has_jakuzzi = has_jakuzzi;
        this.has_sauna = has_sauna;
    }

    public Room() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMax_capacity() {
        return max_capacity;
    }

    public void setMax_capacity(Integer max_capacity) {
        this.max_capacity = max_capacity;
    }

    public Integer getPrice_per_night() {
        return price_per_night;
    }

    public void setPrice_per_night(Integer price_per_night) {
        this.price_per_night = price_per_night;
    }

    public Boolean getHas_jakuzzi() {
        return has_jakuzzi;
    }

    public void setHas_jakuzzi(Boolean has_jakuzzi) {
        this.has_jakuzzi = has_jakuzzi;
    }

    public Boolean getHas_sauna() {
        return has_sauna;
    }

    public void setHas_sauna(Boolean has_sauna) {
        this.has_sauna = has_sauna;
    }
}
