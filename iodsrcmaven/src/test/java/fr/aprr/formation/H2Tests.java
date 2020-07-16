package fr.aprr.formation;

import fr.aprr.formation.entities.Book;
import fr.aprr.formation.repositories.BookH2Repository;
import fr.aprr.formation.repositories.BookSpringJdbcRepository;
import fr.aprr.formation.repositories.CustomerSpringJdbcRepository;
import fr.aprr.formation.services.H2BookFactory;
import fr.aprr.formation.services.IMainService;
import fr.aprr.formation.services.MainService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

import java.sql.SQLException;
import java.util.List;

@SpringBootTest
@Slf4j
class H2Tests {

	@Autowired
	private MainService service;

	@Autowired
	private ApplicationContext context;

	@Autowired
	private H2BookFactory h2;

	@Test
	void h2Test() throws SQLException {
		h2.create();
	}
}
