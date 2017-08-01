package util;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;


@RunWith(SpringJUnit4ClassRunner.class)
@Ignore("Just a testing base class.")
@Configuration
@ContextConfiguration(classes = BaseIntegrationTest.class, loader = AnnotationConfigContextLoader.class)
@ComponentScan({"util"})
public class BaseIntegrationTest extends BaseRestService
{
}
