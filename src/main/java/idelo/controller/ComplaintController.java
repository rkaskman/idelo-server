package idelo.controller;


import idelo.model.citzen.Citizen;
import idelo.model.complaint.Complaint;
import idelo.repository.CitizenRepository;
import idelo.repository.ComplaintRepository;
import idelo.response.JSONListBuilder;
import idelo.response.parts.CitizenComplaintsResponse;
import idelo.response.parts.ComplaintResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class ComplaintController {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private CitizenRepository citizenRepository;

    @RequestMapping(value="/get-all-complaints", method = RequestMethod.GET)
    @ResponseBody
    public List getAllComplaints() {
        return JSONListBuilder.getAllCitizenComplaintsResponse(complaintRepository.findAll());
    }

    @RequestMapping(value="/get-complaint/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public CitizenComplaintsResponse getComplaintById(@PathVariable Long userId) {
        Citizen citizen  = citizenRepository.findOne(userId);
        return new CitizenComplaintsResponse(citizen.getId(),citizen.getName(),citizen.getComplaints());
    }

}