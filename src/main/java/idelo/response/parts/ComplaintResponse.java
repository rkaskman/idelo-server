package idelo.response.parts;

import com.fasterxml.jackson.annotation.JsonProperty;
import idelo.model.complaint.Complaint;
import idelo.model.complaint.StatusOfComplaint;
import idelo.model.complaint.ViolationType;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

public class ComplaintResponse {
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    @JsonProperty(value = "id")
    private Long id;
    @JsonProperty(value = "person")
    private CitizenResponse author;
    @JsonProperty
    private String episodeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty(value = "violationTypes")

    private Collection<ViolationTypeResponse> complaintViolationTypes;
    @JsonProperty(value = "date")
    private String date;
    @JsonProperty(value = "status")
    private StatusOfComplaint statusOfComplaint;
    @JsonProperty(value = "description")
    private String description;
    @JsonProperty(value = "latitude")
    private Double locationLatitude;
    @JsonProperty(value = "longitude")
    private Double locationLongitude;


    public ComplaintResponse(Complaint complaint) {
        this.id = complaint.getId();
        this.author = new CitizenResponse(complaint.getAuthor());
        this.date =  DATE_FORMAT.format(complaint.getDate());
        this.statusOfComplaint = complaint.getStatusOfComplaint();
        this.description = complaint.getDescription();

        this.locationLatitude = complaint.getLocationLatitude();
        this.locationLongitude = complaint.getLocationLongitude();
        this.episodeName = complaint.getEpisodeName();

        this.complaintViolationTypes = new ArrayList();
        for (ViolationType violationType : complaint.getViolationTypes()) {
            this.complaintViolationTypes.add(new ViolationTypeResponse(violationType));
        }
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
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
}