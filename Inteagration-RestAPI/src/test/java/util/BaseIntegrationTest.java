package util;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@Ignore("Just a testing base class.")
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class BaseIntegrationTest extends BaseRestService
{
}
