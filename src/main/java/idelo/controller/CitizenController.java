package idelo.controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import idelo.model.citzen.Citizen;
import idelo.repository.CitizenRepository;
import idelo.response.JSONListBuilder;
import idelo.response.parts.CitizenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@Controller
public class CitizenController {

    @Autowired
    private CitizenRepository citizenRepository;

    @RequestMapping(value = "/get-all-citizen", method = RequestMethod.GET)
    @ResponseBody
    public List getAllCitizen() {
        return JSONListBuilder.getAllCitizenResponse(citizenRepository.findAll());
    }

    @RequestMapping(value = "/get-citizen/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CitizenResponse getCitizenById(@PathVariable Long id) {
        return new CitizenResponse(citizenRepository.findOne(id));
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Long login(@RequestParam("nick") String nick, @RequestParam("password") String password) throws IOException {
        try {
            Citizen citizen = citizenRepository.findByNick(nick).get(0);
            if (citizen.getPass().equals(password)) {
                return citizen.getId();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0l;
    }

}