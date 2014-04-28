package idelo.model.citzen;

import com.fasterxml.jackson.annotation.JsonProperty;
import idelo.model.complaint.Complaint;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Citizen implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @JsonProperty
    private Long id;

    @JsonProperty
    private String name;

    @JsonProperty
    private Sex sex;

    @JsonProperty
    private Date dateOfBirth;

    @JsonProperty
    private String address;

    @JsonProperty
    private Long number;

    @JsonProperty
    private String nick;

    @OneToMany
    @JsonProperty
    private List<Complaint> complaints = new ArrayList<Complaint>();

    @JsonProperty
    private String img;

    @ManyToMany(mappedBy = "listOfCitizenWhoViolated")
    @JsonProperty
    private List<Complaint> complaintsOnThisCitizen = new ArrayList<Complaint>();


    public Citizen() {
    }

    public Citizen(String name, Sex sex) {
        this.name = name;
        this.sex = sex;
    }

    @JsonProperty(value = "numOfComplaints")
    private Integer getNumberOfComplaints(){
        return complaints.size();
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

    public List<Complaint> getComplaintsOnThisCitizen() {
        return complaintsOnThisCitizen;
    }

    public void setComplaintsOnThisCitizen(List<Complaint> complaintsOnThisCitizen) {
        this.complaintsOnThisCitizen = complaintsOnThisCitizen;
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
}