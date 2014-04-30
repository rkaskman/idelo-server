package idelo.response.parts;

import com.fasterxml.jackson.annotation.JsonProperty;
import idelo.model.complaint.Complaint;
import idelo.model.complaint.StatusOfComplaint;
import idelo.model.complaint.TypeOfComplaint;

import java.util.Date;

public class ComplaintResponse {

    @JsonProperty(value = "person")
    private CitizenResponse victim;
    @JsonProperty(value = "type")
    private TypeOfComplaint typeOfComplaint;
    @JsonProperty(value = "date")
    private Date date;
    @JsonProperty(value = "status")
    private StatusOfComplaint statusOfComplaint;

    public ComplaintResponse(Complaint complaint){
        this.victim = new CitizenResponse(complaint.getVictim());
        this.typeOfComplaint  = complaint.getTypeOfComplaint();
        this.date = complaint.getDate();
        this.statusOfComplaint = complaint.getStatusOfComplaint();
    }

    public CitizenResponse getVictim() {
        return victim;
    }

    public void setVictim(CitizenResponse victim) {
        this.victim = victim;
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
}
