package idelo.repository;

import idelo.model.complaint.Complaint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ComplaintRepository extends CrudRepository<Complaint, Long> {
    List<Complaint> findAll();

}
