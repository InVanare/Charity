package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.repository.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
