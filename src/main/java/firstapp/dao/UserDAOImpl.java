package firstapp.dao;

import firstapp.user.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;

@Transactional
@Repository
public class UserDAOImpl extends AbstractDAO<Long, User> implements UserDAO {

    public UserDAOImpl() {
        super(User.class);
    }

    @Override
    public User getUserByLogin(String login) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.login = :login", User.class);
        query.setParameter("login", login);
        return query.getSingleResult();
    }

    @Override
    public void edit(User entity) {
        entityManager.getReference(User.class, entity.getId());
        entityManager.merge(entity);
    }

    @Override
    public void delete(Long id) {
        entityManager.createQuery(
                "DELETE FROM User u WHERE u.id =" + id).executeUpdate();
    }

}
