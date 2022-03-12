package model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class StudentCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne()
    @JoinColumn(name = "course_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Course course;
    @ManyToOne()
    @JoinColumn(name = "student_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Student student;
    private Double score;
    private boolean isPassed;
    public StudentCourse()
    {}
    public StudentCourse(Integer id, Course course, Student student, Double score, boolean isPassed) {
        this.id = id;
        this.course = course;
        this.student = student;
        this.score = score;
        this.isPassed = isPassed;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }

    @Override
    public String toString() {
         return "Student Course id " + id +
                " course=" + course +

                ", score=" + score +
                ", isPassed=" + isPassed +
                '}';
    }
}
