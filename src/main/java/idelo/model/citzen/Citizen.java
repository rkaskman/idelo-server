package idelo.model.citzen;

import idelo.model.complaint.Complaint;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Citizen implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String name;

    private Sex sex;

    private Date dateOfBirth;

    private String address;

    private Long number;

    private String nick;

    private String img;

    @OneToMany(mappedBy = "author")
    private List<Complaint> complaints = new ArrayList<Complaint>();


    public Citizen() {
    }

    public Citizen(String name, Sex sex, Date dateOfBirth, String address, Long number, String nick) {
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.number = number;
        this.nick = nick;
    }

    //GETTERS SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getNick() {
        return nick;
    }

    public void setComplaints(List<Complaint> complaints) {
        this.complaints = complaints;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public List<Complaint> getComplaints() {
        return complaints;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


    @Override
    public String toString() {
        return "Citizen{" +
                "img='" + img + '\'' +
                ", nick='" + nick + '\'' +
                ", number=" + number +
                ", address='" + address + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", sex=" + sex +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Citizen citizen = (Citizen) o;

        if (id != null ? !id.equals(citizen.id) : citizen.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}