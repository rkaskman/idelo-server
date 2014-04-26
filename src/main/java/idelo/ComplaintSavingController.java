package idelo;


import idelo.model.City;
import idelo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class ComplaintSavingController {

    @Autowired
    private CityRepository cityRepository;

    @RequestMapping(value="/saveComplaint", method = RequestMethod.GET)
    public @ResponseBody
    List<City> greeting(
            String jsonString) {
        City city = new City("Tartu", "Tartumaa");
        cityRepository.save(city);
        return cityRepository.findAll();
    }
}