package idelo;


import idelo.model.citzen.Citizen;
import idelo.model.citzen.Sex;
import idelo.model.complaint.Complaint;
import idelo.repository.CitizenRepository;
import idelo.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class GodController {

    @Autowired
    private CitizenRepository citizenRepository;

    @Autowired
    private ComplaintRepository complaintRepository;

    @RequestMapping(value="/saveComplaint", method = RequestMethod.GET)
    public @ResponseBody
    List<Complaint> greeting(String jsonString) {

        Citizen citizen = new Citizen("Ilja", Sex.MALE);
        citizen = citizenRepository.save(citizen);

        Complaint complaint = new Complaint();
        complaint.setAuthor(citizen);
        complaint = complaintRepository.save(complaint);

        ArrayList<Complaint> complaints= new ArrayList();
        complaints.add(complaint);
        citizen.setComplaints(complaints);

        citizenRepository.save(citizen);

        return complaintRepository.findAll();
    }
}