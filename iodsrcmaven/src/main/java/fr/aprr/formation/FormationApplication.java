package fr.aprr.formation;

import fr.aprr.formation.entities.IEntity;
import fr.aprr.formation.entities.Media;
import fr.aprr.formation.services.MainService;
import org.slf4j.IMarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FormationApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FormationApplication.class, args);
	}

	@Autowired
	private MainService service;

	@Autowired
	private ApplicationContext context;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello from Spring Boot");
		Media m = context.getBean("book", Media.class);
		MainService s1 = context.getBean("mainService",MainService.class);

	}
}
