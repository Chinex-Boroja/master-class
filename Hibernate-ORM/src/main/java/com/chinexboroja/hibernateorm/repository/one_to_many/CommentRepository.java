package com.chinexboroja.hibernateorm.repository.one_to_many;

import com.chinexboroja.hibernateorm.entity.one_to_many.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
