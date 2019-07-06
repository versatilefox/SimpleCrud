package firstapp.userService;

import firstapp.user.Role;

import java.util.List;

public interface RoleService {
    void addRole(Role role);

    Role getRoleByName(String roleName);

    Role getRoleById(Long id);

    List<Role> getAllRoles();

    void editRole(Role role);

    void deleteRole(Long id);
}
