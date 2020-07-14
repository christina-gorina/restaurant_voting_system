import org.christinagorina.model.Restaurant;
import org.christinagorina.repository.RestaurantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class MainApp {
    private static final Logger log = LoggerFactory.getLogger(MainApp.class);
    public static void main(String[] args) {
        log.info("MainApp");
        System.out.println("Start");

        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-ap.xml", "spring/spring-db.xml")) {
            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));

            RestaurantRepository repository = appCtx.getBean(RestaurantRepository.class);
            List<Restaurant> restaurantList = repository.getAll();
            System.out.println(restaurantList);

            /*Restaurant restaurant = repository.get(100002);
            System.out.println(restaurant);
            System.out.println(restaurant.getDishes());*/
        }
    }
}

