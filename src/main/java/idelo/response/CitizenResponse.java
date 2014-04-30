package idelo.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import idelo.model.citzen.Citizen;
import idelo.model.citzen.Sex;

import java.util.Date;

public class CitizenResponse {

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
    @JsonProperty
    private Integer numOfComplaints;
    @JsonProperty
    private String img;


    public CitizenResponse(Citizen citizen) {
        this.id = citizen.getId();
        this.name = citizen.getName();
        this.sex = citizen.getSex();
        this.dateOfBirth = citizen.getDateOfBirth();
        this.address = citizen.getAddress();
        this.number = citizen.getNumber();
        this.nick = citizen.getNick();
        this.numOfComplaints = citizen.getComplaints().size();
        this.img =  citizen.getImg();
    }

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

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getNumOfComplaints() {
        return numOfComplaints;
    }

    public void setNumOfComplaints(Integer numOfComplaints) {
        this.numOfComplaints = numOfComplaints;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
