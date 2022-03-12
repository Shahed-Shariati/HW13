package repository;

import model.Person;
import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Set;

public class StudentRepository extends GenericRepositoryImpl<Student,Integer>{


    public StudentRepository()
    {

    }
    public StudentRepository(SessionFactory sessionFactory)
    {
        super.sessionFactory = sessionFactory;
    }

    public List<Student> findAll() {
        try (var session = sessionFactory.openSession()) {
            return session
                    .createQuery("FROM Student",Student.class)
                    .list();
        }
    }

    public Student findById(Integer id){
        try (Session session = sessionFactory.openSession()){
            try {
                return session.get(Student.class,id);
            }catch (Exception e){
                throw e;
            }

        }
    }

    public void truncateTable(){
        try(var session = sessionFactory.openSession()) {
            try {
                Transaction transaction = session.beginTransaction();
                session.createSQLQuery("truncate  table student cascade").executeUpdate();
            }catch (Exception e){
                throw e;
            }

        }
    }
}
