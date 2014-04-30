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
    private Long id;

    private TypeOfComplaint typeOfComplaint;

    private Date date;

    private StatusOfComplaint statusOfComplaint;

    private String description;

    @ManyToOne
    private Citizen author;

    @ManyToOne
    private Citizen victim;

    public Complaint(TypeOfComplaint typeOfComplaint, Date date, StatusOfComplaint statusOfComplaint, String description, Citizen author, Citizen victim) {
        this.typeOfComplaint = typeOfComplaint;
        this.date = date;
        this.statusOfComplaint = statusOfComplaint;
        this.description = description;
        this.author = author;
        this.victim = victim;
    }

    public Complaint() {
    }

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

    public Citizen getVictim() {
        return victim;
    }

    public void setVictim(Citizen victim) {
        this.victim = victim;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Complaint complaint = (Complaint) o;

        if (id != null ? !id.equals(complaint.id) : complaint.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
