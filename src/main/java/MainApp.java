import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class MainApp {
    private static final Logger log = LoggerFactory.getLogger(MainApp.class);
    public static void main(String[] args) {
        log.info("MainApp");
        System.out.println("Start");

        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-db.xml")) {
            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
        }
    }
}

