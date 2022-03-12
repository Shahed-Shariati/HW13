import database.SessionFactorySingleton;
import model.Course;
import model.Person;
import model.Staff;
import org.hibernate.SessionFactory;
import repository.CourseRepository;
import repository.GenericRepositoryImpl;
import repository.PersonRepository;
import repository.StaffRepository;
import service.CourseService;
import service.StaffService;
import utility.Application;
import utility.Menu;

import java.text.ParseException;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
      //  SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();


        Application run = new Application();

            run.runApplication();



    }
}
