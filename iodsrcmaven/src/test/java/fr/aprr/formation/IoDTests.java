package fr.aprr.formation;

import fr.aprr.formation.entities.Media;
import fr.aprr.formation.services.IMainService;
import fr.aprr.formation.services.MainService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

@SpringBootTest
class IoDTests {

	@Autowired
	private IMainService service;

	@Autowired
	private ApplicationContext context;

	@Test
	void serviceTest() {
		Assert.notNull(service,"Not null");
		Assert.notNull(service.getRepository(), "Not null");
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
	}
}
