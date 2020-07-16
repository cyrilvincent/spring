package fr.aprr.formation;

import fr.aprr.formation.entities.Media;
import fr.aprr.formation.repositories.JdbcTest;
import fr.aprr.formation.services.IMainService;
import fr.aprr.formation.services.MainService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class FormationApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FormationApplication.class, args);
	}

	@Autowired
	private IMainService service;

	@Autowired
	private ApplicationContext context;

	//private static Logger log = LoggerFactory.getLogger(FormationApplication.class);

	@Override
	public void run(String... args) throws Exception {
		log.info("Hello from Spring Boot");
		log.info(service.toString());
		log.info(service.getRepository().toString());
		log.info(service.getRepository().getById(0).toString());
		log.info(service.getRepository().getById(0).getTitle());
		Media m = context.getBean("book", Media.class);
		m.setTitle("Java");
		log.info(m.getTitle());
		IMainService s1 = context.getBean("mainService",MainService.class);
		log.info(s1.toString());
		JdbcTest.test();

	}
}
