package repository;

import model.Person;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonRepository extends GenericRepositoryImpl<Person,Integer> implements GenericRepository<Person, Integer>{



    public PersonRepository(){

    }

    public PersonRepository(SessionFactory sessionFactory){
        super.sessionFactory = sessionFactory;
    }
    public Person findById(Integer id){
        try (Session session = sessionFactory.openSession()){
            try {
               return session.get(Person.class,id);
            }catch (Exception e){
                throw e;
            }

        }
    }

     public List<Person> findAll()
     {
          try(Session session = sessionFactory.openSession()){
              Transaction transaction = session.beginTransaction();
              try {
                 return session.createQuery("FROM model.Person",Person.class).getResultList();

              }catch (Exception e){
                  throw e;
              }
          }

     }

     public Person findByUserName(String userName)
     {

         try(Session session = sessionFactory.openSession()) {
               Query query = session.createQuery("SELECT u FROM model.Person u WHERE u.userName = :userName ");
               List<Person> person = query.setParameter("userName",userName).getResultList();

               if(!person.isEmpty())
               {
                   return person.get(0);
               }else {
                   return null;
               }


         }catch (HibernateException e){
             e.printStackTrace();
         }
         return null;


          /*  try(Session session = sessionFactory.openSession()) {

          CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
          var createQuery = criteriaBuilder.createQuery(Person.class);
          var root = createQuery.from(Person.class);
          var userNameEqual = criteriaBuilder.equal(root.get("username"),userName);
           var q = createQuery.select(root)
                                                .where(criteriaBuilder.equal(root.get("userName"),userName));


      }*/
     }

    public void truncateTable(){
        try(var session = sessionFactory.openSession()) {
            try {
                Transaction transaction = session.beginTransaction();
                session.createSQLQuery("truncate  table person cascade").executeUpdate();
            }catch (Exception e){
                throw e;
            }

        }
    }
}
