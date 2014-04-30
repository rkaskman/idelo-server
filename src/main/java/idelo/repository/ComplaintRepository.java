package idelo.repository;

import idelo.model.citzen.Citizen;
import idelo.model.complaint.Complaint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
public interface ComplaintRepository extends CrudRepository<Complaint, Long> {
    List<Complaint> findAll();
}
