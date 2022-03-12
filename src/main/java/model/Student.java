package model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "user_id")
@Inheritance(strategy = InheritanceType.JOINED)
public class Student extends Person{

    @OneToMany(mappedBy = "student",fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<StudentCourse> studentCourses;
    private Double avarag;


    @Transient
    private Set<Term> terms;



    public Student()
    {}

    public Student(Integer id, String firstName, String lastName, String address, String nationalCode, String userName, String passWord, Role role, Set<StudentCourse> studentCourses, Double avarag) {
        super(id, firstName, lastName, address, nationalCode, userName, passWord, role);
        this.studentCourses = studentCourses;
        this.avarag = avarag;
    }

    public Set<StudentCourse> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(Set<StudentCourse> studentCourses) {


        this.studentCourses = studentCourses;
    }

    public Double getAvarag() {
        return avarag;
    }

    public void setAvarag(Double avarag) {
        this.avarag = avarag;
    }

    public Set<Term> getTerms() {
        return terms;
    }

    public void setTerms(Set<Term> terms) {
        this.terms = terms;
    }

    @Override
    public String toString() {
        return  "Student{" +  super.toString() +
                ", avarag=" + avarag +
                ", terms=" + terms +
                '}';
    }
}
