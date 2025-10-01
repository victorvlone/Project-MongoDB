package com.project.demo.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.project.demo.dto.AuthorDTO;
import com.project.demo.dto.CommentDTO;
import com.project.demo.entities.Post;
import com.project.demo.entities.User;
import com.project.demo.repository.PostRepository;
import com.project.demo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, LocalDate.of(2015, 2, 3), "Partiu viagem!", "Vou viajar para São Paulo, abraços!",
                new AuthorDTO(maria));
        Post post2 = new Post(null, LocalDate.of(2018, 12, 5), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", LocalDate.of(2018, 3, 5), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite!", LocalDate.of(2017, 5, 5), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um otimo dia!", LocalDate.of(2019, 6, 5), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }

}
