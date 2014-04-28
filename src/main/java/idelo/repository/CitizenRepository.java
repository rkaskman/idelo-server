package idelo.repository;

import idelo.model.citzen.Citizen;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public interface CitizenRepository extends Repository<Citizen, Long> {

    List<Citizen> findAll();

    Citizen findByNameAllIgnoringCase(String name);

    Citizen save(Citizen citizen);


}