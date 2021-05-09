package fr.aprr.formation;

import fr.aprr.formation.entities.Book;
import fr.aprr.formation.entities.Cd;
import fr.aprr.formation.entities.Customer;
import fr.aprr.formation.entities.Media;
import fr.aprr.formation.repositories.BookJdbcRepository;
import fr.aprr.formation.repositories.CustomerJdbcRepository;
import fr.aprr.formation.services.IMainService;
import fr.aprr.formation.services.MainService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import java.sql.SQLException;
import java.util.List;

@SpringBootTest
@Slf4j
class JdbcTests {

	@Autowired
	private IMainService service;

	@Autowired
	private ApplicationContext context;

	@Autowired
	private BookJdbcRepository repository;

	@Autowired
	private Environment env;

	@Test
	void jdbcTest() throws SQLException {
		List<Book> res = repository.getAll();
		Assert.isTrue(res.size()>0, ">0");
		Book b = res.get(0);
		System.out.println(b.getTitle());
		Assert.isTrue(b.getTitle().equals("Python"), "Python");
	}

	@Test
	void envTest() {
		String s = env.getProperty("app.name");
		log.info(s);
		Assert.isTrue(s.equals("formation"),"Env");
	}


}
