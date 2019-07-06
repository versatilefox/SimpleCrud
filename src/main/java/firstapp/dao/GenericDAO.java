package firstapp.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO <PK extends Serializable, T> {
    void create(T entity);
    void edit(T entity);
    void delete(PK id);
    T find(PK id);
    List<T> findAll();
}
