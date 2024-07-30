package Demo_vlog.service;

import Demo_vlog.Model.Role;

import java.util.List;

public interface RoleService {
    Role saveRole(Role role);
    List<Role> getAllRoles();
    Role getRoleById(Long id);
    Role updateRole(Role role);
    void deleteRole(Long id);
}
