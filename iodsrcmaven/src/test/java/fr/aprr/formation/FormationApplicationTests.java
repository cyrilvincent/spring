package fr.aprr.formation;

import fr.aprr.formation.entities.Book;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class FormationApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void firstTest() {
		Assert.isTrue(1+1==2, "1+1==2");
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

}
