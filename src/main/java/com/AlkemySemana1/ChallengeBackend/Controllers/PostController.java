/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AlkemySemana1.ChallengeBackend.Controllers;

import com.AlkemySemana1.ChallengeBackend.Repositories.PostRepository;
import com.AlkemySemana1.ChallengeBackend.Services.PostService;
import com.AlkemySemana1.ChallengeBackend.entities.Post;
import com.AlkemySemana1.ChallengeBackend.entities.RequestEntities.RequestPost;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author delam
 */
@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    PostRepository postRepo;
    
    // TODO: edit all search filters
    @GetMapping()
    public List<Post> list() {
        return postRepo.findAll();
    }
    
    @GetMapping("/{id}")
    public Post get(@PathVariable Long id) throws Exception {
        return postRepo.getById(id);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        return null;
    }
    
    @PostMapping
    public Post post(@RequestBody RequestPost postRequest) {
        return null;
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }
    
}
