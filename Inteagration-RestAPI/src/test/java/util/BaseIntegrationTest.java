package util;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@Ignore("Just a testing base class.")
@ContextConfiguration(locations = { "classpath:/spring-config.xml" })
public class BaseIntegrationTest extends BaseRestService
{

	final ApplicationContext context = new ClassPathXmlApplicationContext(("spring-config.xml"));

	BaseRestService baseRestService = (BaseRestService) context.getBean("baseRestService");
}
