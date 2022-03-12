package repository;

import database.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public  class GenericRepositoryImpl<T,ID> implements GenericRepository<T,ID> {
   protected SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();

    @Override
    public T save(T t) {
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            try {

                 session.save(t);
                 transaction.commit();
            }catch (Exception e){
              transaction.rollback();
              throw e;
            }
        }
        return t;
    }

    @Override
    public void upDate(T t) {
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            try {
                session.update(t);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }

    @Override
    public void delete(T t) {
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            try {
                session.delete(t);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }







}
