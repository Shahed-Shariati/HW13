package repository;

import model.Person;
import model.Staff;
import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class StaffRepository extends GenericRepositoryImpl<Staff, Integer> {


public StaffRepository()
{

}
public StaffRepository(SessionFactory sessionFactory){
    super.sessionFactory = sessionFactory;
}

    public Staff findById(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            try {
                return session.get(Staff.class, id);
            } catch (Exception e) {
                throw e;
            }
        }
    }
    public List<Staff> findAll() {
        try (var session = sessionFactory.openSession()) {
            return session
                    .createQuery("FROM Staff",Staff.class)
                    .list();
        }
    }

    public void truncateTable(){
        try(var session = sessionFactory.openSession()) {
            try {
                Transaction transaction = session.beginTransaction();
                session.createSQLQuery("truncate  table staff cascade").executeUpdate();
            }catch (Exception e){
                throw e;
            }

        }
    }
}
