package repository;

import model.Course;
import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Set;

public class CourseRepository extends GenericRepositoryImpl<Course,Integer> {

    public CourseRepository(SessionFactory sessionFactory){
       super.sessionFactory = sessionFactory;
    }
    public CourseRepository(){}




    public Course findById(Integer id){
        try (Session session = sessionFactory.openSession()){
            try {
                return session.get(Course.class,id);
            }catch (Exception e){
                throw e;
            }

        }
    }

    public List<Course> findAll()
    {
        try (var session = sessionFactory.openSession()) {
            return session
                    .createQuery("select c FROM Course c",Course.class)
                    .list();
        }
    }

    public void truncateTable(){
        try(var session = sessionFactory.openSession()) {
            try {
                Transaction transaction = session.beginTransaction();
                session.createSQLQuery("truncate  table course cascade").executeUpdate();
            }catch (Exception e){
                throw e;
            }

        }
    }

}
