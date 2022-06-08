package pl.coderslab.charity.repository;

import org.springframework.data.repository.CrudRepository;
import pl.coderslab.charity.repository.entity.Donation;

public interface DonationRepository extends CrudRepository<Donation, Long> {
}
