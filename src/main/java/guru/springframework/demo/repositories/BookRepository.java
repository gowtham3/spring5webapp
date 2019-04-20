package guru.springframework.demo.repositories;

import guru.springframework.demo.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface BookRepository extends CrudRepository<Book, Long> {
}
