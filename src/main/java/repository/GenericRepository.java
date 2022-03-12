package repository;

import java.util.Set;

public interface GenericRepository <T,ID>{
    T save(T t);
    void upDate(T t);
    void delete(T t);






}
