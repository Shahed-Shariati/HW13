package repository;

import database.SessionFactoryJunit;
import model.Course;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseRepositoryTest {

    private SessionFactory sessionFactory = SessionFactoryJunit.getSessionFactory();
    private CourseRepository courseRepository;
    private Course course;

    @BeforeEach
    void initial()
    {
        courseRepository = new CourseRepository(sessionFactory);
        course = new Course(null,"riazy",2,null);
    }



    @Test
    void connectionTest(){
        //Arrange
        //Act
        //Assert
        assertDoesNotThrow(() -> {
            SessionFactory sessionFactory1 = SessionFactoryJunit.getSessionFactory();
        });
    }



    @Test
    void save()
    {
        //Arrange


        //Act
        courseRepository.save(course);

        //Assert
        assertEquals(1,course.getId());

    }
    @Test
    void findById() {

        //Arrange
        courseRepository.save(course);

        //Act
        Course course1 = courseRepository.findById(course.getId());

        //Assert

        assertEquals(1,course1.getId());
        assertEquals("riazy",course1.getName());
    }


    @Test
    void delete()
    {
        //Arrange
        courseRepository.save(course);

        //Act
         courseRepository.delete(course);
        //Assert

        assertNull(courseRepository.findById(course.getId()));
    }
    @Test
    void findAll() {
        //Arrange
        courseRepository.save(course);
        courseRepository.save(course);
            //Act
        List<Course> courses = courseRepository.findAll();

        //Assert
        assertEquals(2,courses.size());
    }



    @AfterEach
    void truncate()
    {
        courseRepository.truncateTable();
        //  userRepository.truncate();
    }

    //Arrange

    //Act

    //Assert
}