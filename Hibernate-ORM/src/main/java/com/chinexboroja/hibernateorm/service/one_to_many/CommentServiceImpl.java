package com.chinexboroja.hibernateorm.service.one_to_many;

import com.chinexboroja.hibernateorm.entity.one_to_many.Comment;
import com.chinexboroja.hibernateorm.repository.one_to_many.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
