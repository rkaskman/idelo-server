package idelo.model.citzen;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import idelo.model.complaint.Complaint;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,
        property="@id")
@Entity
public class Citizen implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String name;

    private Sex sex;

    private Date dateOfBirth;

    private String address;

    private String pass;

    private Long number;

    private String nick;

    private String img;

    @OneToMany(mappedBy = "author")
    private List<Complaint> complaints = new ArrayList<Complaint>();


    public Citizen() {
    }

    public Citizen(String name, Sex sex, Date dateOfBirth, String address, Long number, String nick, String pass) {
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.number = number;
        this.nick = nick;
        this.pass = pass;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

        if (address != null ? !address.equals(citizen.address) : citizen.address != null) return false;
        if (complaints != null ? !complaints.equals(citizen.complaints) : citizen.complaints != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(citizen.dateOfBirth) : citizen.dateOfBirth != null) return false;
        if (id != null ? !id.equals(citizen.id) : citizen.id != null) return false;
        if (img != null ? !img.equals(citizen.img) : citizen.img != null) return false;
        if (name != null ? !name.equals(citizen.name) : citizen.name != null) return false;
        if (nick != null ? !nick.equals(citizen.nick) : citizen.nick != null) return false;
        if (number != null ? !number.equals(citizen.number) : citizen.number != null) return false;
        if (pass != null ? !pass.equals(citizen.pass) : citizen.pass != null) return false;
        if (sex != citizen.sex) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (nick != null ? nick.hashCode() : 0);
        result = 31 * result + (img != null ? img.hashCode() : 0);
        result = 31 * result + (complaints != null ? complaints.hashCode() : 0);
        return result;
    }
}