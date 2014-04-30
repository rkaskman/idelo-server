package idelo.response;


import idelo.model.citzen.Citizen;
import idelo.model.complaint.Complaint;
import idelo.response.parts.CitizenComplaintsResponse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Thin Controller for json, may become god class, so be ready for decoupling.
 * Hint: maybe it is good idea to create service for parsing JSON???
 * */
public class JSONBuilder {

    public static List<CitizenComplaintsResponse> getCitizenComplaintsResponse(List<Complaint> allComplaints) {
        List<CitizenComplaintsResponse> citizenComplaintsResponse = new ArrayList<>();

        HashSet<Citizen> authors = new HashSet<>();
        for (Complaint complaint : allComplaints) {
            authors.add(complaint.getAuthor());
        }

        for (Citizen author : authors) {
            citizenComplaintsResponse.add(new CitizenComplaintsResponse(
                    author.getId(), author.getName(), author.getComplaints()));
        }
        return citizenComplaintsResponse;
    }

}
