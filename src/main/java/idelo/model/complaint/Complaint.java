package idelo.model.complaint;


import idelo.model.citzen.Citizen;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
public class Complaint implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private Date date;

    private StatusOfComplaint statusOfComplaint;

    private String description;

    private Double locationLatitude;

    private Double locationLongitude;
    @OneToMany(mappedBy = "complaint")
    private Collection<Image> images;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name="complaint_violation_type",
            joinColumns={@JoinColumn(name="complaint", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="violation_type", referencedColumnName="id")})
    private Collection<ViolationType> violationTypes;

    @ManyToOne
    private Citizen author;

    // for testing purposes only
    public Complaint(Date date, StatusOfComplaint statusOfComplaint, String description, Double locationLatitude,
                     Double locationLongitude, Collection<Image> images,
                     Collection<ViolationType> violationTypes,
                     Citizen author) {
        this.date = date;
        this.statusOfComplaint = statusOfComplaint;
        this.description = description;
        this.locationLatitude = locationLatitude;
        this.locationLongitude = locationLongitude;
        this.images = images;
        this.violationTypes = violationTypes;
        this.author = author;
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

    public Double getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(Double locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    public Double getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(Double locationLongitude) {
        this.locationLongitude = locationLongitude;
    }

    public Collection<Image> getImages() {
        return images;
    }

    public void setImages(Collection<Image> images) {
        this.images = images;
    }

    public Collection<ViolationType> getViolationTypes() {
        return violationTypes;
    }

    public void setViolationTypes(Collection<ViolationType> violationTypes) {
        this.violationTypes = violationTypes;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "description='" + description + '\'' +
                ", statusOfComplaint=" + statusOfComplaint +
                ", date=" + date +
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
