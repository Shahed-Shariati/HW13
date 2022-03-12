package repository;

import database.SessionFactoryJunit;
import model.Course;
import model.Role;
import model.Student;
import model.StudentCourse;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    private StudentCourseRepository studentCourseRepository;
    private SessionFactory sessionFactory;
    private Student student;
    private PersonRepository personRepository;
    @BeforeEach
    void initialTest()
    {
        sessionFactory = SessionFactoryJunit.getSessionFactory();
        studentRepository = new StudentRepository(sessionFactory);
        courseRepository = new CourseRepository(sessionFactory);
        personRepository = new PersonRepository(sessionFactory);
        studentCourseRepository = new StudentCourseRepository(sessionFactory);
        student = new Student(null,"ss","ss","ss","ss","ss","ss",null,null,20.5);
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
    void findAll() {
        //Arrange

        studentRepository.save(student);
        studentRepository.save(student);
        //Act

        List<Student> studentList = studentRepository.findAll();
        //Assert
         assertEquals(2,studentList.size());
    }

    @Test
    void delete()
    {
        studentRepository.save(student);
        //Act
        studentRepository.delete(student);
        //Assert

        assertNull(studentRepository.findById(student.getId()));
    }
    @Test
    void save(){
        //Arrange

        //Act
       studentRepository.save(student);

        //Assert
        assertNotNull(studentRepository.findById(student.getId())); }

  @Test
   void findById(){
      //Arrange
       studentRepository.save(student);

      //Act
      Student     studentFind =  studentRepository.findById(1);
      //Assert
        assertTrue(studentFind.getStudentCourses().isEmpty());
  }

   @AfterEach
    void truncate(){
       studentRepository.truncateTable();
       personRepository.truncateTable();
   }

}