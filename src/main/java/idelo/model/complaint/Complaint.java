package idelo.model.complaint;


import com.fasterxml.jackson.annotation.JsonProperty;
import idelo.model.citzen.Citizen;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Complaint implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @JsonProperty
    private Long id;

    @ManyToOne
    @JsonProperty
    private Citizen author;

    @ManyToMany
    @JsonProperty(value = "list")
    private Set<Citizen> listOfCitizenWhoViolated = new HashSet<Citizen>();

    @JsonProperty(value = "type")
    private  TypeOfComplaint typeOfComplaint;

    @JsonProperty(value = "date")
    private Date date;

    @JsonProperty(value = "status")
    private StatusOfComplaint statusOfComplaint;

    @JsonProperty
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Citizen getAuthor() {
        return author;
    }

    public void setAuthor(Citizen author) {
        this.author = author;
    }

    public Set<Citizen> getListOfCitizenWhoViolated() {
        return listOfCitizenWhoViolated;
    }

    public void setListOfCitizenWhoViolated(Set<Citizen> listOfCitizenWhoViolated) {
        this.listOfCitizenWhoViolated = listOfCitizenWhoViolated;
    }

    public TypeOfComplaint getTypeOfComplaint() {
        return typeOfComplaint;
    }

    public void setTypeOfComplaint(TypeOfComplaint typeOfComplaint) {
        this.typeOfComplaint = typeOfComplaint;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public StatusOfComplaint getStatusOfComplaint() {
        return statusOfComplaint;
    }

    public void setStatusOfComplaint(StatusOfComplaint statusOfComplaint) {
        this.statusOfComplaint = statusOfComplaint;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "description='" + description + '\'' +
                ", statusOfComplaint=" + statusOfComplaint +
                ", date=" + date +
                ", typeOfComplaint=" + typeOfComplaint +
                ", author=" + author +
                ", id=" + id +
                '}';
    }
}
