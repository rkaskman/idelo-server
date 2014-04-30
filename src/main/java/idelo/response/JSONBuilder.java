package idelo.response;


import idelo.model.citzen.Citizen;
import idelo.model.complaint.Complaint;
import idelo.response.parts.CitizenComplaintsResponse;
import idelo.response.parts.CitizenResponse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Thin Controller for json, may become god class, so be ready for decoupling.
 * Hint: maybe it is good idea to create services for this JSON controller???
 * */
public class JSONBuilder {

    public static List<CitizenComplaintsResponse> getAllCitizenComplaintsResponse(List<Complaint> allComplaints) {
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

    public static List<CitizenResponse> getAllCitizenResponse(List<Citizen> allCitizen) {
        List<CitizenResponse> allCitizenResponse = new ArrayList<>();

        for (Citizen citizen : allCitizen) {
            allCitizenResponse.add(new CitizenResponse(citizen));
        }

        return allCitizenResponse;
    }

}
