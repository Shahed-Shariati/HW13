package service;

import database.SessionFactorySingleton;
import model.Course;
import model.Staff;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import repository.CourseRepository;

import javax.transaction.Transactional;
import java.util.List;

public class CourseService extends GenericServiceImpl<Course,Integer>{
    CourseRepository courseRepository = new CourseRepository();


       @Override
       public Course findById(Integer id)
       {
         return   courseRepository.findById(id);
       }

    public List<Course> findAll(){
        return courseRepository.findAll();
    }
}
