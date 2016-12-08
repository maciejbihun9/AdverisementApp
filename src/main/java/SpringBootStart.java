import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Maciek on 2016-11-12.
 */
@EnableAutoConfiguration
@ComponentScan({"controller", "config", "util/page_parser_utils", "service", "serviceImpl", "model/modelTranslator"})
public class SpringBootStart {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStart.class, args);
    }

}
