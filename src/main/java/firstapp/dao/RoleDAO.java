package firstapp.dao;

import firstapp.user.Role;

public interface RoleDAO extends GenericDAO<Long, Role> {

    Role getRoleByName(String name);
}
