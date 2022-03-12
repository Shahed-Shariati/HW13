package service;

import exception.UserNotFound;
import model.Student;
import repository.StudentRepository;

import java.util.List;

public class StudentService extends GenericServiceImpl<Student,Integer>{

    private StudentRepository studentRepository = new StudentRepository();
    public Student findById(Integer id){
        Student student =  studentRepository.findById(id);
           if(student != null){
               return student;
           }else {
               throw  new UserNotFound();
           }

    }

    public  List<Student> findAll(){
        return studentRepository.findAll();
    }

    public void upDate(Student student){
        studentRepository.upDate(student);
    }
}
