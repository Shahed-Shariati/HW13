package service;

import database.SessionFactorySingleton;
import org.hibernate.SessionFactory;
import repository.GenericRepositoryImpl;

import java.util.List;
import java.util.Set;

public class GenericServiceImpl<T,ID> implements GenericService<T ,ID> {
  protected  GenericRepositoryImpl<T, ID> genericRepository = new GenericRepositoryImpl<T,ID>() ;
 // protected SessionFactory sessionFactory = SessionFactorySingleton.getSessionFactory();

    @Override
    public T save(T t) {

        return genericRepository.save(t);
    }

    @Override
    public void delete(T t) {

        genericRepository.delete(t);
    }

    @Override
    public T findById(ID id) {

        return null;
    }

    @Override
    public void upDate(T t) {
        genericRepository.upDate(t);
    }


}
