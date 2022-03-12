package repository;

import model.Professor;
import model.Student;
import org.hibernate.Session;

import java.util.List;

public class ProfessorRepository extends GenericRepositoryImpl<Professor,Integer> implements GenericRepository<Professor,Integer>{


    public List<Professor> findAll() {
        try (var session = sessionFactory.openSession()) {
            return session
                    .createQuery("FROM Professor",Professor.class)
                    .list();
        }
    }

    public Professor findById(Integer id){
        try (Session session = sessionFactory.openSession()){
            try {
                return session.get(Professor.class,id);
            }catch (Exception e){
                throw e;
            }

        }
    }
}
