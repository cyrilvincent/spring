package fr.aprr.formation;

import fr.aprr.formation.entities.Book;
import fr.aprr.formation.entities.Media;
import fr.aprr.formation.repositories.MockBookRepository;
import fr.aprr.formation.services.MainService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

@SpringBootTest
class IoDTests {

	private MainService service;
	private ApplicationContext context;

	@Test
	void serviceTest() {
		MainService service=null;
		Assert.notNull(service,"Not null");
		Assert.notNull(service.getRepository() != null, "Not null");
	}

	@Test
	void repoTest() {
		MainService service=null;
		Media m = service.getRepository().getById(0);
		Assert.isTrue(m.getTitle().equals("Java"), "repoTest");
	}

	@Test
	void beanTest() {
		// Construire un Book via getBean et tester
		// Reconstruire le service via getBean

	}
}
