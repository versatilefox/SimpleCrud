package firstapp.dao;

import firstapp.user.Role;
import firstapp.user.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;

@Transactional
@Repository
public class RoleDAOImpl extends AbstractDAO<Long, Role> implements RoleDAO{

    public RoleDAOImpl() {
        super(Role.class);
    }

    @Override
    public Role getRoleByName(String name) {
        TypedQuery<Role> query = entityManager.createQuery("SELECT r FROM Role r WHERE r.name = :name", Role.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
