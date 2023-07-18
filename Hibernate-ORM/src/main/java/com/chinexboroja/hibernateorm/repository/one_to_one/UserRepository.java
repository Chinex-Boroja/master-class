package com.chinexboroja.hibernateorm.repository.one_to_one;

import com.chinexboroja.hibernateorm.entity.one_to_one.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
