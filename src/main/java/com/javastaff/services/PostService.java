package com.javastaff.services;

import com.javastaff.entities.Post;

public interface PostService {

    Iterable<Post> listPosts();

    Post getPostById(Integer id);

    Post savePost(Post product);

    void deletePost(Integer id);

}
