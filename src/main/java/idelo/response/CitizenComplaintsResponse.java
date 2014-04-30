package idelo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import idelo.model.complaint.Complaint;

import java.util.ArrayList;
import java.util.List;

public class CitizenComplaintsResponse {

    @JsonProperty
    private Long authorId;
    @JsonProperty
    private String authorName;
    @JsonProperty(value = "list")
    private List<ComplaintResponse> complaintsOfCitizen = new ArrayList<>();

    CitizenComplaintsResponse(Long authorId, String authorName, List<Complaint> complaintsOfCitizen) {
        this.authorId = authorId;
        this.authorName = authorName;

        for (Complaint complaint : complaintsOfCitizen) {
            this.complaintsOfCitizen.add(new ComplaintResponse(complaint));
        }
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<ComplaintResponse> getComplaintsOfCitizen() {
        return complaintsOfCitizen;
    }

    public void setComplaintsOfCitizen(List<ComplaintResponse> complaintsOfCitizen) {
        this.complaintsOfCitizen = complaintsOfCitizen;
    }

    @Override
    public String toString() {
        return "CitizenComplaintsResponse{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", complaintsOfCitizen=" + complaintsOfCitizen +
                '}';
    }
}
