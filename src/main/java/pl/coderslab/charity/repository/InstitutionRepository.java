package pl.coderslab.charity.repository;

import org.springframework.data.repository.CrudRepository;
import pl.coderslab.charity.repository.entity.Institution;

public interface InstitutionRepository extends CrudRepository<Institution, Long> {
}
