package fr.aprr.formation;

import fr.aprr.formation.entities.Book;
import fr.aprr.formation.entities.Customer;
import fr.aprr.formation.repositories.BookJdbcRepository;
import fr.aprr.formation.repositories.CustomerSpringJdbcRepository;
import fr.aprr.formation.services.IMainService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.util.Assert;

import java.sql.SQLException;
import java.util.List;

@SpringBootTest
@Slf4j
class SpringJdbcTests {

	@Autowired
	private IMainService service;

	@Autowired
	private ApplicationContext context;

	@Autowired
	private CustomerSpringJdbcRepository customerRepository;

	@Test
	void customerTest() throws SQLException {
		List<Customer> res = customerRepository.getAll();
		Assert.isTrue(res.size()>0, ">0");
		Customer c = res.get(0);
		System.out.println(c.getLname());
		Assert.isTrue(c.getLname().equals("Palmer"), "Palmer");
	}



}
