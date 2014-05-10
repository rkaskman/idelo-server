package idelo.controller;


import idelo.model.citzen.Citizen;
import idelo.model.complaint.Complaint;
import idelo.model.complaint.Image;
import idelo.model.complaint.ViolationType;
import idelo.repository.CitizenRepository;
import idelo.repository.ComplaintRepository;
import idelo.repository.ViolationTypeRepository;
import idelo.response.JSONListBuilder;
import idelo.response.parts.CitizenComplaintsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class ComplaintController {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private CitizenRepository citizenRepository;

    @Autowired
    private ViolationTypeRepository violationTypeRepository;

    @RequestMapping(value = "/get-all-complaints", method = RequestMethod.GET)
    @ResponseBody
    public List getAllComplaints() {
        return JSONListBuilder.getAllCitizenComplaintsResponse(complaintRepository.findAll());
    }

    @RequestMapping(value = "/get-complaint/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public CitizenComplaintsResponse getComplaintById(@PathVariable Long userId) {
        Citizen citizen = citizenRepository.findOne(userId);
        return new CitizenComplaintsResponse(citizen.getId(), citizen.getName(), citizen.getComplaints());
    }

    @RequestMapping(value = "/newComplaint", method = RequestMethod.POST, consumes = "application/json;")
    @ResponseBody
    public String addNewComplaint(@RequestBody final Complaint complaint) {

        List<ViolationType> violationTypes = new ArrayList<>();
        for (ViolationType violationType : complaint.getViolationTypes()) {
            violationTypes.add(violationTypeRepository.findByName(violationType.getName()).get(0));
        }
        complaint.setViolationTypes(violationTypes);
        for (Image image : complaint.getImages()) {
            image.setComplaint(complaint);
        }
        complaintRepository.save(complaint);
        return "OK";
    }

    @RequestMapping(value = "/getAllViolationTypes", method = RequestMethod.GET)
    @ResponseBody
    public List<ViolationType> getViolationTypes() {
        return violationTypeRepository.findAll();
    }
}