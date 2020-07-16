package fr.aprr.formation;

import fr.aprr.formation.entities.Cd;
import fr.aprr.formation.entities.Customer;
import fr.aprr.formation.entities.Media;
import fr.aprr.formation.repositories.CustomerJdbcRepository;
import fr.aprr.formation.services.IMainService;
import fr.aprr.formation.services.MainService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class IoDTests {

	@Autowired
	private IMainService service;

	@Autowired
	private ApplicationContext context;

	@Autowired
	private CustomerJdbcRepository repository;

	@Test
	void serviceTest() {
		Assert.notNull(service,"Not null");
		Assert.notNull(service.getRepository(), "Not null");
		assertNotNull(service);

	}

	@Test
	void repoTest() {
		Media m = service.getRepository().getById(0);
		Assert.isTrue(m.getTitle().equals("Java"), "repoTest");
	}

	@Test
	void beanTest() {
		Media m = context.getBean("book", Media.class);
		Assert.notNull(m, "NotNull");
		IMainService s1 = context.getBean("mainService", MainService.class);
		System.out.println(s1);
		Cd cd = new Cd();
	}

	@Test
	void customerJdbcTest() throws ClassNotFoundException, SQLException {
		List<Customer> res = repository.getAll();
		Assert.isTrue(res.size()>0, ">0");
		Customer c = res.get(0);
		System.out.println(c.getLname());
		Assert.isTrue(c.getLname().equals("Palmer"), "Palmer");

	}
}
