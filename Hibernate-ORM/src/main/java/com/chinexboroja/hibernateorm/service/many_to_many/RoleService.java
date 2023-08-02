package com.chinexboroja.hibernateorm.service.many_to_many;

import com.chinexboroja.hibernateorm.entity.many_to_many.Role;

import java.util.List;

public interface RoleService {

    Role createRole(Role role);

    List<Role> getAllRoles();

    Role getRoleById(Long id);
}
