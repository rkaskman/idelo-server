package idelo.response.parts;

import com.fasterxml.jackson.annotation.JsonProperty;
import idelo.model.complaint.Complaint;
import idelo.model.complaint.Image;
import idelo.model.complaint.StatusOfComplaint;
import idelo.model.complaint.ViolationType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class ComplaintResponse {

    @JsonProperty(value = "person")
    private CitizenResponse author;
    @JsonProperty(value = "violationTypes")
    private Collection<ViolationTypeResponse> complaintViolationTypes;
    @JsonProperty(value = "date")
    private Date date;
    @JsonProperty(value = "status")
    private StatusOfComplaint statusOfComplaint;
    @JsonProperty(value = "images")
    private Collection<ImageResponse> images;
    @JsonProperty(value = "description")
    private String description;
    @JsonProperty(value = "latitude")
    private Double locationLatitude;
    @JsonProperty(value = "longitude")
    private Double locationLongitude;


    public ComplaintResponse(Complaint complaint) {
        this.author = new CitizenResponse(complaint.getAuthor());
        this.date = complaint.getDate();
        this.statusOfComplaint = complaint.getStatusOfComplaint();
        this.description = complaint.getDescription();

        this.locationLatitude = complaint.getLocationLatitude();
        this.locationLongitude = complaint.getLocationLongitude();
        this.images = new ArrayList();
        for (Image image : complaint.getImages()) {
            this.images.add(new ImageResponse(image));
        }
        this.complaintViolationTypes = new ArrayList();
        for (ViolationType violationType : complaint.getViolationTypes()) {
            this.complaintViolationTypes.add(new ViolationTypeResponse(violationType));
        }
    }

    public CitizenResponse getAuthor() {
        return author;
    }

    public void setAuthor(CitizenResponse author) {
        this.author = author;
    }

    public Collection<ViolationTypeResponse> getComplaintViolationTypes() {
        return complaintViolationTypes;
    }

    public void setComplaintViolationTypes(Collection<ViolationTypeResponse> complaintViolationTypes) {
        this.complaintViolationTypes = complaintViolationTypes;
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

    public Double getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(Double locationLongitude) {
        this.locationLongitude = locationLongitude;
    }

    public Double getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(Double locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<ImageResponse> getImages() {
        return images;
    }

    public void setImages(Collection<ImageResponse> images) {
        this.images = images;
    }
}