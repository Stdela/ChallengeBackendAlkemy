
package com.AlkemySemana1.ChallengeBackend.Services;

import com.AlkemySemana1.ChallengeBackend.Repositories.PostRepository;
import com.AlkemySemana1.ChallengeBackend.entities.Post;
import com.AlkemySemana1.ChallengeBackend.entities.RequestEntities.RequestPost;
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

    public Post createPost(RequestPost reqPost){
        Post post = new Post();
        post.setTitle(reqPost.getTitle());
        post.setCategory(reqPost.getCategory());
        post.setContent(reqPost.getContent());
        post.setCreationDate(LocalDate.now());
        post.setImage(reqPost.getImage());
        postRep.save(post);
        
        
       
        
        
    }
    
}
