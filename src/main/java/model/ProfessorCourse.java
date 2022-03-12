package model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class ProfessorCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Course course;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professor_id")
    private Professor professor;
    private String term;

    public ProfessorCourse() {
    }

    public ProfessorCourse(Integer id, Course course, Professor professor, String term) {
        this.id = id;
        this.course = course;
        this.professor = professor;
        this.term = term;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}
