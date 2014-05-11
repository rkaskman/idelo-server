package idelo.controller;


import idelo.model.citzen.Citizen;
import idelo.model.complaint.Complaint;
import idelo.repository.CitizenRepository;
import idelo.repository.ComplaintRepository;
import idelo.response.parts.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private CitizenRepository citizenRepository;

    @Autowired
    private ComplaintRepository complaintRepository;

    @RequestMapping(value = "search/{query}", method = RequestMethod.GET)
    @ResponseBody
    public SearchResponse search(@PathVariable String query) {
        List<Citizen> allCitizens = citizenRepository.findAll();
        List<Complaint> allComplaints = complaintRepository.findAll();

        List<Citizen> citizens = new ArrayList<Citizen>();
        for (Citizen citizen : allCitizens) {
            if(citizen.getName().contains(query) || citizen.getNick().contains(query)){
                citizens.add(citizen);
            }
        }

        List<Complaint> complaints = new ArrayList<Complaint>();
        for (Complaint complaint : allComplaints) {
            if(containsEpisodeName(query, complaint) || containsDescription(query, complaint)){
                complaints.add(complaint);
            }
        }

        return new SearchResponse(citizens, complaints);
    }

    private boolean containsDescription(String query, Complaint complaint) {
        try {
            return complaint.getDescription().contains(query);
        }catch (Exception e){
            return  false;
        }
    }

    private boolean containsEpisodeName(String query, Complaint complaint) {
        try {
        return complaint.getEpisodeName().contains(query);
        }catch (Exception e){
            return  false;
        }

    }

}
