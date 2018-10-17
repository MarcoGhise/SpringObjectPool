package it.blog.springobjectpool.test;

import static org.junit.Assert.*;
import it.blog.springobjectpool.GatewayController;
import it.blog.springobjectpool.response.ResultRest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MultiThreadedRunner.class)
public class PoolTest {
	
	static ApplicationContext context;
		
	@BeforeClass
	public static void setup()
	{
		context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/springobjectpool-servlet.xml");		
	}
	
	
	@Test 
	public void test100()
	{		
		GatewayController controller = (GatewayController)context.getBean(GatewayController.class);
		
		ResultRest result = controller.pool(100);

		assertEquals(result.getRetCode(), 100);
	}

	@Test
	public void test200()
	{		
		GatewayController controller = (GatewayController)context.getBean(GatewayController.class);
		
		ResultRest result = controller.pool(200);

		assertEquals(result.getRetCode(), 200);
	}
	
	@Test
	public void test300()
	{		
		GatewayController controller = (GatewayController)context.getBean(GatewayController.class);
		
		ResultRest result = controller.pool(300);
		
		assertEquals(result.getRetCode(), 300);
	}
	
}
