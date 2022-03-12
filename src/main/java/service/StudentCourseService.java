package service;

import model.StudentCourse;
import repository.StudentCourseRepository;

import java.util.List;

public class StudentCourseService extends GenericServiceImpl<StudentCourse,Integer>{

    private StudentCourseRepository studentCourseRepository = new StudentCourseRepository();
    public List<StudentCourse> findByStudentId(Integer id)
    {
      List<StudentCourse> studentCourseList =  studentCourseRepository.findByStudentId(id);
      if(!studentCourseList.isEmpty())
      {
          return studentCourseList;
      }else {
          return null;
      }
    }
}
