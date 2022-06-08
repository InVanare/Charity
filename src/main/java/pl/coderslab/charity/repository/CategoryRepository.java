package pl.coderslab.charity.repository;

import org.springframework.data.repository.CrudRepository;
import pl.coderslab.charity.repository.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
