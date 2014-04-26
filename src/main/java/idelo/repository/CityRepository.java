package idelo.repository;

import idelo.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public interface CityRepository extends Repository<City, Long> {

    List<City> findAll();

    City findByNameAllIgnoringCase(String name);

    City save(City city);

}