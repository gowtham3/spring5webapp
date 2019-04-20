package guru.springframework.demo.repositories;

import guru.springframework.demo.model.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
