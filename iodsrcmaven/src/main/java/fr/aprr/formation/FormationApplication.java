package fr.aprr.formation;

import fr.aprr.formation.entities.Media;
import fr.aprr.formation.services.IMainService;
import fr.aprr.formation.services.MainService;
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
	private IMainService service;

	@Autowired
	private ApplicationContext context;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello from Spring Boot");
		System.out.println(service);
		System.out.println(service.getRepository());
		System.out.println(service.getRepository().getById(0));
		System.out.println(service.getRepository().getById(0).getTitle());
		Media m = context.getBean("book", Media.class);
		m.setTitle("Java");
		System.out.println(m.getTitle());
		IMainService s1 = context.getBean("mainService",MainService.class);
		System.out.println(s1);
	}
}
