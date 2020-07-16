package fr.aprr.formation;

import fr.aprr.formation.entities.Book;
import fr.aprr.formation.entities.Customer;
import fr.aprr.formation.repositories.CustomerJdbcRepository;
import fr.aprr.formation.repositories.MockBookRepository;
import fr.aprr.formation.services.IMainService;
import fr.aprr.formation.services.MainService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class FormationApplicationTests {
	@Test
	void contextLoads() {
	}

	@Test
	void firstTest() {

		Assert.isTrue(1+1==2, "1+1==2");
		assertEquals(1+1,2);
	}

	@Test
	void singletonTest() {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		Assert.isTrue(s1.hashCode() == s2.hashCode(), "Singleton");
	}

	@Test
	void bookTest() {
		Book b = new Book(0,"Java",10);
		Assert.notNull(b,"Not null");
	}

	@Test
	void repositoryTest() {
		MockBookRepository repo = new MockBookRepository();
		Book b = repo.getById(0);
		Assert.isTrue("Java" == b.getTitle(),"getById");
		Assert.isTrue(repo.getAll().size() == 2, "getAll");
	}

	@Test
	void serviceTest() {
		MockBookRepository repo = new MockBookRepository();
		IMainService service = new MainService();
		service.getCart().add(new Book(0,"Java",10));
		service.getCart().add(new Book(0,"Java",10));
		assertEquals(21.1, service.getTotalNetPrice(),0.01);
	}


}
