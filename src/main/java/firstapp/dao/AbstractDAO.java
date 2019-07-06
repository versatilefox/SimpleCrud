package firstapp.dao;

import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Transactional
public abstract class AbstractDAO<PK extends Serializable, T> {

    @PersistenceContext
    EntityManager entityManager;

    private final Class <T> tClass;

    AbstractDAO(Class<T> tClass) {
        this.tClass = tClass;
    }

    public void create(T entity){
        entityManager.persist(entity);
    }

    public void edit(T entity){
        entityManager.merge(entity);
    }

    public void delete(PK id){
        entityManager.find(tClass, id);
    }

    public T find(PK id){
        return entityManager.find(tClass, id);
    }

    public List<T> findAll(){
        return entityManager.createQuery("From " + tClass.getSimpleName()).getResultList();
    }
}
