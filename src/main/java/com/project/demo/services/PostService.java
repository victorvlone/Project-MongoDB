package com.project.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.demo.entities.Post;
import com.project.demo.repository.PostRepository;
import com.project.demo.services.exception.ObjectNotFoundException;

public class PostService {

    @Autowired
    private PostRepository postRepository;


    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
