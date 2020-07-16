package fr.aprr.formation;

import fr.aprr.formation.services.H2BookFactory;
import fr.aprr.formation.services.JPAService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
class JPATests {

	@Autowired
	private JPAService service;

	@Autowired
	private ApplicationContext context;

	@Test
	void pgTest() throws SQLException {
		service.addToCart(1);
		service.addToCart(2);
		log.info(service.getCart().toString());
		log.info("TotalNetPrice:"+service.getTotalNetPrice());
		assertEquals(21.1,service.getTotalNetPrice(),0.01);
	}
}
