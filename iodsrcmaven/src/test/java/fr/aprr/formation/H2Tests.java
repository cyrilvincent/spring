package fr.aprr.formation;

import fr.aprr.formation.services.H2BookFactory;
import fr.aprr.formation.services.H2Service;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

@SpringBootTest
@Slf4j
class H2Tests {

	@Autowired
	private H2Service service;

	@Autowired
	private ApplicationContext context;

	@Autowired
	private H2BookFactory h2;

	@Test
	void h2Test() throws SQLException {
		h2.create();
		service.addToCart(6);
		service.addToCart(7);
		log.info(service.getCart().toString());
		log.info("TotalNetPrice:"+service.getTotalNetPrice());
		assertEquals(21.1,service.getTotalNetPrice(),0.01);
	}
}
