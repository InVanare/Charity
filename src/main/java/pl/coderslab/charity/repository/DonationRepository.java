package pl.coderslab.charity.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.repository.entity.Donation;
import pl.coderslab.charity.repository.entity.User;

import java.util.List;
import java.util.Optional;

public interface DonationRepository extends JpaRepository<Donation, Long> {
    @Query("select sum(d.quantity) from Donation d")
    Integer sumAllQuantity();
    @Query("select count(d) from Donation d")
    Integer countAll();
    @Query(value = "select * from donations d, user u where u.username = ?1 order by d.id limit ?2 offset ?3", nativeQuery = true)
    List<Donation> findAllByUser(String username, Integer limit, Integer offset);

    List<Donation> findAllByUser(User user, Pageable pageable);
    //@Query("select count(d) from Donation d, User u where u = ?1")
    @Query("select count(d) from Donation d inner join User u on u.id = d.user where u.username = ?1")
    Integer countAllByUser(String username);

}
