package fr.aprr.formation;

import fr.aprr.formation.entities.Author;
import fr.aprr.formation.entities.Book;
import fr.aprr.formation.entities.Publisher;
import fr.aprr.formation.repositories.AuthorJPARepository;
import fr.aprr.formation.repositories.PublisherJPARepository;
import fr.aprr.formation.services.H2BookFactory;
import fr.aprr.formation.services.JPAService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class JPATests {

	@Autowired
	private JPAService service;

	@Autowired
	private ApplicationContext context;

	@Autowired
	private PublisherJPARepository publisherRepository;

	@Autowired
	private AuthorJPARepository authorRepository;

	@Test
	void pgTest() throws SQLException {
		service.addToCart(1);
		service.addToCart(2);
		log.info(service.getCart().toString());
		log.info("TotalNetPrice:"+service.getTotalNetPrice());
		assertEquals(21.1,service.getTotalNetPrice(),0.01);
	}

	@Test
	void publisherTest() {
		Publisher p = publisherRepository.findById(1);
		assertNotNull(p);
		Book b = service.getRepository().findById(1);
		assertEquals(p.getId(), b.getPublisher().getId());
		List<Book> books = service.getRepository().findByPublisherId(1);
		assertTrue(books.size() > 0);
//		Book b2 = new Book("Spring",10,100);
//		b2.setPublisher(p);
//		service.getRepository().save(b2);
	}

	@Test
	void authorTest() {
		Book b = service.getRepository().findById(1);
		List<Author> authors = b.getAuthors();
		assertTrue(authors.size() > 0);
	}

	@Test
	void jpqlTest() {
		Author a = authorRepository.findById(1);
		List<Book> books = a.getBooks();
		assertTrue(books.size() > 0);
	}
}
