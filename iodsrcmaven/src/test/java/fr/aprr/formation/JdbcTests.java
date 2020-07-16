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

import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class JdbcTests {

	@Autowired
	private IMainService service;

	@Autowired
	private ApplicationContext context;

	@Autowired
	private CustomerJdbcRepository repository;

	@Test
	void jdbcTest() {
		/*
		Créer la table book(id(serial),title(varying char),price(float),nbpage(int nullable))
		Créer BookJdbcRepository
		Créer le test
		 */
	}


}
