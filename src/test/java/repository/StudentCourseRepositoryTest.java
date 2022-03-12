package repository;

import database.SessionFactoryJunit;
import model.Course;
import model.Student;
import model.StudentCourse;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentCourseRepositoryTest {
   private StudentCourseRepository studentCourseRepository;
   private SessionFactory sessionFactory;
   private StudentCourse studentCourse;
   private StudentRepository studentRepository;
   private CourseRepository courseRepository;
   private Student student;
   private Course course;


   @BeforeEach
   void initial()

   {
       sessionFactory = SessionFactoryJunit.getSessionFactory();
       studentCourseRepository = new StudentCourseRepository(sessionFactory);
       studentRepository = new StudentRepository(sessionFactory);
       courseRepository = new CourseRepository(sessionFactory);
       student = new Student(null,"ss","ss","ss","ss","ss","ss",null,null,20.5);
       course = new Course(null,"riazy",2,null);
       studentCourse = new StudentCourse();

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
   void save(){
       //Arrange
        studentRepository.save(student);
        courseRepository.save(course);
        studentCourse.setStudent(student);
        studentCourse.setCourse(course);
       // student.setStudentCourses(new HashSet<>(Arrays.asList(studentCourse)));

      //Act
      // studentRepository.upDate(student);
       studentCourseRepository.save(studentCourse);
       //Assert
      assertNotNull(studentCourseRepository.findByStudentId(student.getId()));


   }
    @Test
    void findByStudentId() {

       //Arrange
        studentRepository.save(student);
        courseRepository.save(course);
        studentCourse.setStudent(student);
        studentCourse.setCourse(course);
        studentCourseRepository.save(studentCourse);
        //Act
       List<StudentCourse> studentCourse = studentCourseRepository.findByStudentId(student.getId());

        //Assert
        assertEquals(1,studentCourse.size());
    }

    @Test
    void delete()
    {
        // Arrange
        studentRepository.save(student);
        courseRepository.save(course);
        studentCourse.setStudent(student);
        studentCourse.setCourse(course);
        studentCourseRepository.save(studentCourse);
        //Act
        studentCourseRepository.delete(studentCourse);
        //assert
        assertTrue(studentCourseRepository.findByStudentId(student.getId()).isEmpty());

    }

    @AfterEach
    void truncate()
    {

        studentCourseRepository.truncateTable();
        studentRepository.truncateTable();
        courseRepository.truncateTable();
    }

}