package com.chinexboroja.hibernateorm.service.one_to_many;

import com.chinexboroja.hibernateorm.entity.one_to_many.Post;
public interface PostService {

    Post createPost(Post post);

    Post getPostById(Long id);
}
