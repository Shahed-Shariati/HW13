package model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer unit;
    @OneToMany(mappedBy = "course")
    Set<StudentCourse> studentCourseSet;

    public Course() {
    }

    public Course(Integer id, String name, Integer unit, Set<StudentCourse> studentCourseSet) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.studentCourseSet = studentCourseSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Set<StudentCourse> getStudentCourseSet() {
        return studentCourseSet;
    }

    public void setStudentCourseSet(Set<StudentCourse> studentCourseSet) {
        this.studentCourseSet = studentCourseSet;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unit=" + unit +

                '}';
    }
}
