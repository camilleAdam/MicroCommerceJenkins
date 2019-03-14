package com.ecommerce.microcommerce;

import com.ecommerce.microcommerce.web.controller.ProductController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MicrocommerceApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void doSomething(){

		ProductController controller = new ProductController();
		controller.saySomething();
		String something = "somethng";
		assertEquals(something, controller.saySomething());
	}

}
