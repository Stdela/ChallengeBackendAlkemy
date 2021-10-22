package com.AlkemySemana1.ChallengeBackend.Services;

import com.AlkemySemana1.ChallengeBackend.Repositories.PostRepository;
import com.AlkemySemana1.ChallengeBackend.entities.Post;
import com.AlkemySemana1.ChallengeBackend.entities.RequestEntities.RequestPost;
import com.AlkemySemana1.ChallengeBackend.entities.updateEntities.UpdatePost;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author delam
 */
@Service
public class PostService {

    @Autowired
    PostRepository postRep;

    public Post createPost(RequestPost reqPost) {
        Post post = new Post();
        post.setTitle(reqPost.getTitle());
        post.setCategory(reqPost.getCategory());
        post.setContent(reqPost.getContent());
        post.setCreationDate(LocalDate.now());
        post.setImage(reqPost.getImage());
        return postRep.save(post);
         

    }

    public Post updatePost(UpdatePost updatePost, Long id) {
        Post post = postRep.findById(id).get();
        post.setContent(updatePost.getContent());
        post.setCategory(updatePost.getCategory());
        post.setImage(updatePost.getImage());
        post.setTitle(updatePost.getTitle());
        return postRep.save(post);
        
    }

}
