package com.javastaff.repositories;

import org.springframework.data.repository.CrudRepository;

import com.javastaff.entities.Post;

public interface PostRepository extends CrudRepository<Post, Integer> {

}
