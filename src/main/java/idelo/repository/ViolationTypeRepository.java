package idelo.repository;

import idelo.model.complaint.ViolationType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ViolationTypeRepository extends CrudRepository<ViolationType, Integer> {

    List<ViolationType> findByName(String name);

    List<ViolationType> findAll();
}
