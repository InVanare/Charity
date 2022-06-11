package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.repository.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
}