package formation.spring.iod;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class IodApplicationTests {

	@Autowired
	private MyService s2;

	@Test
	void service() {
		MyService s = new MyService(new MyRepository());
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

}
