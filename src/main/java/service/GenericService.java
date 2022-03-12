package service;

import repository.GenericRepositoryImpl;


import java.util.Set;

public interface GenericService <T ,ID>{
    T save(T t);
    void delete(T t);
    T findById(ID id);
    void upDate(T t);




}
