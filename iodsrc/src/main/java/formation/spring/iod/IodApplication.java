package formation.spring.iod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class IodApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory.getLogger(IodApplication.class);
	private MyService iodservice;

	public static void main(String[] args) {
		SpringApplication.run(IodApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Spring from println");
		MyService s = new MyService(new MyRepository());
		System.out.println(s.getById(1).getValue());
		System.out.println(s.getById(2).getValue());
		System.out.println(s.getByLombokId(3).getValue());

	}
}
