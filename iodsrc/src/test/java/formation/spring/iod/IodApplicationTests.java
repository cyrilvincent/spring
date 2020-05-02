package formation.spring.iod;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

@SpringBootTest
class IodApplicationTests {

	@Autowired
	private IMyService s2;
	@Autowired
	private ApplicationContext context;

	@Test
	void service() {
		IMyService s = new MyService(new MyRepository());
		int i = s.getById(1).getValue();
		Assert.isTrue(i==1,"Service = 1");
	}

	@Test
	void service2() {
		int i = s2.getById(2).getValue();
		Assert.isTrue(i==2,"Service = 2");
	}

	@Test
	void lombokService() {
		int i = s2.getByLombokId(3).getValue();
		Assert.isTrue(i==3,"Service = 3");
	}

	@Test
	void iocService() {
		IMyService s = context.getBean("myService",IMyService.class);
		int i = s.getByLombokId(4).getValue();
		Assert.isTrue(i==4,"Service = 4");
	}

}
