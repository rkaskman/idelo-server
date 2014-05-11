package idelo.response.parts;

import com.fasterxml.jackson.annotation.JsonProperty;
import idelo.model.citzen.Citizen;
import idelo.model.complaint.Complaint;
import idelo.model.complaint.ViolationType;

import java.util.ArrayList;
import java.util.List;

public class SearchResponse {
    @JsonProperty
    private List<CitizenResponse> persons = new ArrayList<CitizenResponse>();
    @JsonProperty
    private List<ComplaintResponse> viloations = new ArrayList<ComplaintResponse>();

    public SearchResponse(List<Citizen> citizens, List<Complaint> complaints) {
        for (Citizen person : citizens) {
            persons.add(new CitizenResponse(person));
        }
        for (Complaint complaint : complaints) {
            viloations.add(new ComplaintResponse(complaint));
        }
    }

    @Override
    public String toString() {
        return "SearchResponse{" +
                "persons=" + persons +
                ", viloations=" + viloations +
                '}';
    }
}
