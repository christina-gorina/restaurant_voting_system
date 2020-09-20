import org.christinagorina.model.Restaurant;
import org.christinagorina.repository.DishRepository;
import org.christinagorina.repository.RestaurantRepository;
import org.christinagorina.repository.VoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static java.time.LocalDate.now;
import static java.time.LocalDateTime.of;

public class MainApp {
    private static final Logger log = LoggerFactory.getLogger(MainApp.class);
    public static void main(String[] args) {
        log.info("MainApp");
        System.out.println("Start");

        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml")) {
            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));

            RestaurantRepository restaurantRepository = appCtx.getBean(RestaurantRepository.class);
            //DishRepository dishRepository = appCtx.getBean(DishRepository.class);
            //VoteRepository voteRepository = appCtx.getBean(VoteRepository.class);

            //Restaurant restaurant = restaurantRepository.get(100012);
            //System.out.println(restaurant);

            /*List<Restaurant> restaurantList = restaurantRepository.getAll();
            System.out.println(restaurantList);*/

            /*Restaurant restaurantList = restaurantRepository.getWithDishes(100011);
            System.out.println(restaurantList);
            System.out.println(restaurantList.getDishes());*/

            //List<Restaurant> restaurantList = restaurantRepository.getAllWithVotesByDate(LocalDateTime.of(2020, 7, 5, 5, 7, 3), LocalDateTime.of(2020, 7, 3, 3, 7, 4));
            //System.out.println("------------------------");
           // System.out.println(restaurantList.size());
           // restaurantList.forEach(r -> {
            //    System.out.println(r);
            //    System.out.println("+");
            //    System.out.println(r.getVotes());
            //    System.out.println("------------------------");
            //});

            //service.delete(100011);

            /*Restaurant rst = restaurantRepository.save(new Restaurant(null, "новый"));
            System.out.println(rst);*/

            /*Restaurant rest = restaurantRepository.get(100011);
            System.out.println(rest);*/

            //Dish dish =  dishRepository.save(new Dish(null, "еда", now(), 500), 100011);

            /*boolean asn = dishRepository.delete(100014, 100011);
            System.out.println(asn);*/

            /*List<Dish> dishes = dishRepository.getByDateAndRestaurant(100011, LocalDate.of(2020, 7, 3));
            dishes.forEach(System.out::println);*/

            //Restaurant res = restaurantRepository.getWithDishesByDate(100012, LocalDate.of(2020, 7, 5));
            //System.out.println(res);
            //System.out.println(res.getDishes());

            /*Restaurant res = restaurantRepository.getWithDishesByDateAndVotesByDate(100011, LocalDate.of(2020, 7, 3));
            System.out.println(res);
            System.out.println(res.getDishes());
            System.out.println(res.getVotes());*/

            /*Restaurant res = restaurantRepository.getWithVotesByDate(100011, LocalDate.of(2020, 7, 3));
            System.out.println(res);
            System.out.println(res.getVotes());*/

          /*  List<Votes> vt = voteRepository.getAllByDateAndRestaurant(100011, LocalDateTime.of(2020, 7, 3, 2020, 7, 3), LocalDateTime.of(2020, 7, 3, 2020, 7, 4));
            vt.forEach(System.out::println);
*/
            Set<Restaurant> restaurantList = restaurantRepository.getAllWithDishesByDate(LocalDate.of(2020, 7, 5));
            System.out.println("------------------------");
             System.out.println(restaurantList.size());
             restaurantList.forEach(r -> {
                System.out.println(r);
                System.out.println("+");
                System.out.println(r.getDishes());
                System.out.println("------------------------");
            });
        }
    }
}

