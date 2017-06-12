package com.javastaff.services;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javastaff.entities.Post;
import com.javastaff.repositories.PostRepository;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public void setProductRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Iterable<Post> listPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Integer id) {
        return postRepository.findOne(id);
    }

    @Override
    public Post savePost(Post post) {
    	if (post.getId()==null) {
    		post.setCreated(Calendar.getInstance().getTime());
    	}
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Integer id) {
        postRepository.delete(id);
    }

}
