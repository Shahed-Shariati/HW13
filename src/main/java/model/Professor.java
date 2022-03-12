package model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
@Entity
@PrimaryKeyJoinColumn(name = "userId")
public class Professor extends Employee {

     private Boolean isEmployee;

    @OneToMany(mappedBy = "professor",fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<ProfessorCourse> professorCourses;

    public Professor(){

    }

    public Professor(Integer id, String firstName, String lastName, String address, String nationalCode, String userName, String passWord, Role role, Double salary, Boolean isEmployee, List<ProfessorCourse> professorCourses) {
        super(id, firstName, lastName, address, nationalCode, userName, passWord, role, salary);
        this.isEmployee = isEmployee;
        this.professorCourses = professorCourses;
    }


    public Boolean getEmployee() {
        return isEmployee;
    }

    public void setEmployee(Boolean employee) {
        isEmployee = employee;
    }

    public List<ProfessorCourse> getProfessorCourses() {
        return professorCourses;
    }

    public void setProfessorCourses(List<ProfessorCourse> professorCourses) {
        this.professorCourses = professorCourses;
    }
}
