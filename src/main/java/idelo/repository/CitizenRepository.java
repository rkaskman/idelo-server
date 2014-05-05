package idelo.repository;

import idelo.model.citzen.Citizen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public interface CitizenRepository extends CrudRepository<Citizen, Long> {

    List<Citizen> findAll();

    List<Citizen> findByNick(String nick);

}