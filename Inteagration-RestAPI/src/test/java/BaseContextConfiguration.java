import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;


@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
@ContextConfiguration(classes = BaseContextConfiguration.class, loader = AnnotationConfigContextLoader.class)
@ComponentScan({ "com.util" })
@PropertySource("project.properties")
public class BaseContextConfiguration
{
	@Value("${baseUrl}")
	protected String baseUrl;
	@Value("${basePort}")
	protected String basePort;
}
