package guru.springframework.demo.bootstrap;

import guru.springframework.demo.model.Author;
import guru.springframework.demo.model.Book;
import guru.springframework.demo.model.Publisher;
import guru.springframework.demo.repositories.AuthorRepository;
import guru.springframework.demo.repositories.BookRepository;
import guru.springframework.demo.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Author eric = new Author("Eric", "Evens");
        Book ddd = new Book("Domain driven design", "1234");
        Publisher publisher = new Publisher("Harper Collins", "Mexico");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);

        publisherRepository.save(publisher);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noELB = new Book("J2EE  development", "23444");
        Publisher US = new Publisher("Works", "US");
        rod.getBooks().add(noELB);
        noELB.setPublisher(US);
//        noELB.getAuthors().add(rod);
        publisherRepository.save(US);
        authorRepository.save(rod);
        bookRepository.save(noELB);
    }
}
