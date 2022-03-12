package repository;

import model.Student;
import model.StudentCourse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.util.List;

public class StudentCourseRepository extends GenericRepositoryImpl<StudentCourse,Integer> implements GenericRepository<StudentCourse,Integer> {
    public StudentCourseRepository()
    {}
    public StudentCourseRepository(SessionFactory sessionFactory)
    {
        super.sessionFactory = sessionFactory;
    }
    public List<StudentCourse> findByStudentId(Integer id){
        try(Session session = sessionFactory.openSession()) {
            try {
                return   session.createQuery("SELECT s FROM StudentCourse s WHERE s.student.id = :id",StudentCourse.class)
                        .setParameter("id",id)
                        .getResultList();
            }catch (Exception e){
                throw e;
            }

        }
    }

    public void truncateTable(){
        try(var session = sessionFactory.openSession()) {
            try {
                Transaction transaction = session.beginTransaction();
                session.createSQLQuery("truncate  table studentcourse cascade").executeUpdate();
            }catch (Exception e){
                throw e;
            }

        }
    }
}
