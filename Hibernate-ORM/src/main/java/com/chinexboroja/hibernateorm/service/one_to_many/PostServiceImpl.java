package com.chinexboroja.hibernateorm.service.one_to_many;

import com.chinexboroja.hibernateorm.entity.one_to_many.Post;
import com.chinexboroja.hibernateorm.repository.one_to_many.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post Not Found"));
    }
}
