package idelo.controller;


import idelo.repository.CitizenRepository;
import idelo.response.JSONListBuilder;
import idelo.response.parts.CitizenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class CitizenController {

    @Autowired
    private CitizenRepository citizenRepository;

    @RequestMapping(value="/get-all-citizen", method = RequestMethod.GET)
    @ResponseBody
    public List getAllCitizen() {
        return JSONListBuilder.getAllCitizenResponse(citizenRepository.findAll());
    }

    @RequestMapping(value="/get-citizen/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CitizenResponse getCitizenById(@PathVariable Long id) {
        return new CitizenResponse(citizenRepository.findOne(id));
    }

}