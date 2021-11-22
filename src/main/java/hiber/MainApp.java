package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

//import static jdk.internal.org.jline.utils.InfoCmp.Capability.*;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("John", "Snow", "gmail@gmail.com");
      user1.setCar(new Car("Audi", 8));

      User user2 = new User("Tirion", "Lannister", "gmail@gmail.com");
      user2.setCar(new Car("Toyota", 15));



      List<User> users = userService.listUsers("Audi", 8);
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("car = " + user.getCar().toString());
         System.out.println();
      }

      context.close();
   }
}
