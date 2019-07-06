package firstapp.userService;

import firstapp.dao.RoleDAO;
import firstapp.user.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleDAO roleDAO;

    @Autowired
    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Transactional(rollbackFor = Exception.class, readOnly = false)
    @Override
    public void addRole(Role role) {
        roleDAO.create(role);
    }

    @Transactional(rollbackFor = Exception.class, readOnly = false)
    @Override
    public Role getRoleByName(String roleName) {
        return roleDAO.getRoleByName(roleName);
    }

    @Transactional(rollbackFor = Exception.class, readOnly = false)
    @Override
    public Role getRoleById(Long id) {
        return roleDAO.find(id);
    }

    @Transactional(rollbackFor = Exception.class, readOnly = false)
    @Override
    public List<Role> getAllRoles() {
        return roleDAO.findAll();
    }

    @Transactional(rollbackFor = Exception.class, readOnly = false)
    @Override
    public void editRole(Role role) {
        roleDAO.edit(role);
    }

    @Transactional(rollbackFor = Exception.class, readOnly = false)
    @Override
    public void deleteRole(Long id) {
        roleDAO.delete(id);
    }
}
