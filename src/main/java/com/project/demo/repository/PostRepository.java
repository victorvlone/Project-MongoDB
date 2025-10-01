package com.project.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

    
}
