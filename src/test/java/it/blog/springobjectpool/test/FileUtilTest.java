package it.blog.springobjectpool.test;

import static org.junit.Assert.*;

import java.util.List;

import it.blog.springobjectpool.GatewayController;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MultiThreadedRunner.class)
public class FileUtilTest {
	
	static ApplicationContext context;
		
	@BeforeClass
	public static void setup()
	{
		context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/springobjectpool-servlet.xml");		
	}
		
	@Test 
	public void test1()
	{		
		GatewayController controller = (GatewayController)context.getBean(GatewayController.class);
		
		List<String> result = controller.file("messages.properties");

		assertNotNull(result);
	}
	
	@Test 
	public void test2()
	{		
		GatewayController controller = (GatewayController)context.getBean(GatewayController.class);
		
		List<String> result = controller.file("MobileAction");

		assertNotNull(result);
	}
	
	@Test 
	public void test3()
	{		
		GatewayController controller = (GatewayController)context.getBean(GatewayController.class);
		
		List<String> result = controller.file("Engine");

		assertNotNull(result);
	}
	

}
