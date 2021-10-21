/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AlkemySemana1.ChallengeBackend.Repositories;

import com.AlkemySemana1.ChallengeBackend.entities.DtoEntities.PostDto;
import com.AlkemySemana1.ChallengeBackend.entities.Post;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author delam
 */
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT NEW com.AlkemySemana1.ChallengeBackend.entities.DtoEntities.PostDto(p.id, p.title, p.content, p.image, p.category, p.creationDate)"
            + " from Post p WHERE p.title = :title ORDER BY p.creationDate DESC ")
    List<PostDto> findByTitle(String title);

    @Query("SELECT NEW com.AlkemySemana1.ChallengeBackend.entities.DtoEntities.PostDto(p.id, p.title, p.content, p.image, p.category, p.creationDate)"
            + " from Post p WHERE p.category = :category ORDER BY p.creationDate DESC ")
    List<PostDto> findByCategory(String category);

    @Query("SELECT NEW com.AlkemySemana1.ChallengeBackend.entities.DtoEntities.PostDto(p.id, p.title, p.content, p.image, p.category, p.creationDate)"
            + "ORDER BY p.creationDate DESC ")
    List<PostDto> findPosts();

}
