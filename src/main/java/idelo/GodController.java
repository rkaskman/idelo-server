package idelo;


import idelo.model.citzen.Citizen;
import idelo.model.citzen.Sex;
import idelo.model.complaint.Complaint;
import idelo.model.complaint.StatusOfComplaint;
import idelo.model.complaint.TypeOfComplaint;
import idelo.repository.CitizenRepository;
import idelo.repository.ComplaintRepository;
import idelo.response.JSONBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;


@Controller
public class GodController {

    @Autowired
    private CitizenRepository citizenRepository;

    @Autowired
    private ComplaintRepository complaintRepository;


    @RequestMapping(value="/get-all-complaints", method = RequestMethod.GET)
    @ResponseBody
    public List getAllComplaints() {
        return JSONBuilder.getAllCitizenComplaintsResponse(complaintRepository.findAll());
    }

    @RequestMapping(value="/get-all-citizen", method = RequestMethod.GET)
    @ResponseBody
    public List getAllCitizen() {
        return JSONBuilder.getAllCitizenResponse(citizenRepository.findAll());
    }


    @RequestMapping(value="/generate", method = RequestMethod.GET)
    @ResponseBody
    public void generate() {
        Citizen ilja = new Citizen("Ilja", Sex.MALE, new Date(100,1,2),"Tartu, Kesklinn" ,12322L ,"@ilj");
        Citizen roman =  new Citizen("Roman", Sex.MALE, new Date(101,1,2),"Tallinn, Musta" ,52322123L ,"@rom");
        Citizen pavel =  new Citizen("Pavel", Sex.MALE, new Date(123,1,2),"Tallinn, Lasna" ,312322L ,"@pvl");

        citizenRepository.save(ilja);
        citizenRepository.save(roman);
        citizenRepository.save(pavel);

        Complaint complaint = new Complaint(
                TypeOfComplaint.ANTI_GOVERNMENT_TALKS, new Date(123,1,2), StatusOfComplaint.NEW, "Roman was speaking to loudly!",
                ilja, roman);
        complaintRepository.save(complaint);

        Complaint complaint3 = new Complaint(
                TypeOfComplaint.DANGEROUS_PHYLOSOPHING, new Date(143,1,2), StatusOfComplaint.RESOLVED, "Pavel is annoying!",
                ilja, pavel);
        complaintRepository.save(complaint3);

        Complaint complaint2 = new Complaint(
                TypeOfComplaint.ANTI_GOVERNMENT_TALKS, new Date(124,1,2), StatusOfComplaint.NEW, "I dont like him!",
                roman, pavel);
        complaintRepository.save(complaint2);
    }
}