package idelo.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import idelo.model.citzen.Citizen;
import idelo.model.complaint.Complaint;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllComplaintsResponse {

    @JsonProperty
    private  List<CitizenComplaintsResponse> citizenComplaintsResponse = new ArrayList<>();

    public AllComplaintsResponse(List<Complaint> allComplaints) {
        HashSet<Citizen> authors = new HashSet<>();
        for (Complaint complaint : allComplaints) {
            authors.add(complaint.getAuthor());
        }

        for (Citizen author : authors) {
            citizenComplaintsResponse.add(new CitizenComplaintsResponse(
                    author.getId(), author.getName(), author.getComplaints()));
        }
    }


    public List<CitizenComplaintsResponse> getCitizenComplaintsResponse() {
        return citizenComplaintsResponse;
    }

    public void setCitizenComplaintsResponse(List<CitizenComplaintsResponse> citizenComplaintsResponse) {
        this.citizenComplaintsResponse = citizenComplaintsResponse;
    }

    @Override
    public String toString() {
        return "AllComplaintsResponse{" +
                "citizenComplaintsResponse=" + citizenComplaintsResponse +
                '}';
    }
}
