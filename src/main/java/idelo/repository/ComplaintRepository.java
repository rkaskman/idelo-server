package idelo.repository;

import idelo.model.citzen.Citizen;
import idelo.model.complaint.Complaint;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ComplaintRepository extends Repository<Complaint, Long> {

    Complaint save(Complaint complaint);

    List<Complaint> findAll();

}
