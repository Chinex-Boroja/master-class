package com.chinexboroja.hibernateorm.repository.one_to_many;

import com.chinexboroja.hibernateorm.entity.one_to_many.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
