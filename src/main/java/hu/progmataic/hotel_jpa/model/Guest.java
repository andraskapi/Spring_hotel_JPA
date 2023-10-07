package hu.progmataic.hotel_jpa.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
    public class Guest {

    @Id
    private Integer id;
    private String title;
    private String family_name;
    private String first_name;
    private String place_of_birth;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date_of_birth;
    private String identification_number;
    private String email;

    public Guest(Integer id, String title, String family_name, String first_name,
                 String place_of_birth, Date date_of_birth,
                 String identification_number, String email) {
        this.id = id;
        this.title = title;
        this.family_name = family_name;
        this.first_name = first_name;
        this.place_of_birth = place_of_birth;
        this.date_of_birth = date_of_birth;
        this.identification_number = identification_number;
        this.email = email;
    }

    public Guest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getIdentification_number() {
        return identification_number;
    }

    public void setIdentification_number(String identification_number) {
        this.identification_number = identification_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
