package formation.spring.iod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class IodApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory.getLogger(IodApplication.class);
	@Autowired
	private IMyService iodservice;
	@Autowired
	private ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(IodApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Spring from println");
		IMyService s = new MyService(new MyRepository());
		System.out.println(s.getById(1).getValue());
		System.out.println(s.getById(2).getValue());
		System.out.println(s.getByLombokId(3).getValue());
		s = context.getBean("myService",IMyService.class);
		System.out.println(s.getByLombokId(4).getValue());


	}
}
