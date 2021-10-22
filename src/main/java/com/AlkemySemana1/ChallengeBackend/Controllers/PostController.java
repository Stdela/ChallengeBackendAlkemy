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
import com.AlkemySemana1.ChallengeBackend.entities.updateEntities.UpdatePost;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping()
    public List postist(@RequestParam(required = false) String title, @RequestParam(required = false) String category) throws Exception {

        if (title != null && category != null) {
            String title1 = title.replace("-", " ");
            String category1 = category.replace("-", " ");
            postRepo.findByTitleAndCategory(title1, category1);
        } else if (title != null) {

            String title1 = title.replace("-", " ");
            return postRepo.findByTitle(title1);
        } else if (category != null) {
            String category1 = category.replace("-", " ");
            return postRepo.findByCategory(category1);
        } else {
            return postRepo.findPosts();
        }

        return postRepo.findPosts();

    }

    @GetMapping("/{id}")
    public Post get(@PathVariable Long id) throws Exception {
        return postRepo.getById(id);
    }

    @PatchMapping("/{id}")
    public Post patch(@PathVariable Long id, @RequestBody UpdatePost updatePost) {
        return postService.updatePost(updatePost, id);
    }

    @PostMapping
    public Post post(@RequestBody RequestPost postRequest) {
        return postService.createPost(postRequest);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        postRepo.deleteById(id);
    }

}
