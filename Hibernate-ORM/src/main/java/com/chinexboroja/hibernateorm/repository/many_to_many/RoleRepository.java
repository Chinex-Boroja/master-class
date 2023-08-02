package com.chinexboroja.hibernateorm.repository.many_to_many;

import com.chinexboroja.hibernateorm.entity.many_to_many.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
