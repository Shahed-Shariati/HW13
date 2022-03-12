package service;

import exception.UserNotFound;
import model.Course;
import model.Professor;
import model.ProfessorCourse;
import model.Student;
import repository.ProfessorRepository;

import java.util.List;

public class ProfessorService extends GenericServiceImpl<Professor,Integer> {
private ProfessorRepository professorRepository = new ProfessorRepository();
public List<Professor> findAll(){
    return professorRepository.findAll();
}
    public Professor findById(Integer id){
        Professor professor =  professorRepository.findById(id);
        if( professor != null){
            return professor;
        }else {
            throw  new UserNotFound();
        }

    }

    public Double salary(Professor professor){
        Integer sum = professor.getProfessorCourses()
                .stream()
                .map(ProfessorCourse::getCourse)
                .mapToInt(Course::getUnit)
                .sum();
    if(professor.getEmployee()){

        return (1000000d * sum) + 5000000;
    }else {
         return (1000000d * sum);
    }


    }

}
