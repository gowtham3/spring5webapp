package guru.springframework.demo.repositories;

import guru.springframework.demo.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
