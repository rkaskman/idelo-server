package idelo.controller;


import idelo.model.citzen.Citizen;
import idelo.model.citzen.Sex;
import idelo.repository.CitizenRepository;
import idelo.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


@Controller
public class AppController {

    @Autowired
    private CitizenRepository citizenRepository;

    @Autowired
    private ComplaintRepository complaintRepository;

    @RequestMapping(value="/generate", method = RequestMethod.GET)
    @ResponseBody
    public void generate() {
        Citizen ilja = new Citizen("Ilja", Sex.MALE, new Date(100,1,2),"Tartu, Kesklinn" ,12322L ,"ilja@idelo.com", "pass");
        Citizen roman =  new Citizen("Roman", Sex.MALE, new Date(101,1,2),"Tallinn, Musta" ,52322123L ,"roma@idelo.com", "pass123");
        Citizen pavel =  new Citizen("Pavel", Sex.MALE, new Date(123,1,2),"Tallinn, Lasna" ,312322L ,"pavel@gmail.com", "123pass");

        citizenRepository.save(ilja);
        citizenRepository.save(roman);
        citizenRepository.save(pavel);

//        Complaint complaint = new Complaint(
//                new Date(123,1,2), StatusOfComplaint.NEW, "Roman was speaking to loudly!",
//                ilja, roman);
//        complaintRepository.save(complaint);
//
//        Complaint complaint3 = new Complaint(
//                 new Date(143,1,2), StatusOfComplaint.RESOLVED, "Pavel is annoying!",
//                ilja, pavel);
//        complaintRepository.save(complaint3);
//
//        Complaint complaint2 = new Complaint(
//                 new Date(124,1,2), StatusOfComplaint.NEW, "I dont like him!",
//                roman, pavel);
//        complaintRepository.save(complaint2);
    }
}