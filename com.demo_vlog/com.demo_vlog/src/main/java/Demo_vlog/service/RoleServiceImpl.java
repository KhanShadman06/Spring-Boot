package Demo_vlog.service;

import Demo_vlog.Model.Role;
import Demo_vlog.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Role updateRole(Long id, Role role) {
        Role existingRole = roleRepository.findById(id).orElse(null);
        if (existingRole != null) {
            existingRole.setName(role.getName());
            // Add any other fields that need to be updated
            return roleRepository.save(existingRole);
        }
        return null;
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
