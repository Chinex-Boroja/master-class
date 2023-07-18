package com.chinexboroja.hibernateorm.service.one_to_many;

import com.chinexboroja.hibernateorm.entity.one_to_many.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getAllComments();

    Comment createComment(Comment comment);
}
