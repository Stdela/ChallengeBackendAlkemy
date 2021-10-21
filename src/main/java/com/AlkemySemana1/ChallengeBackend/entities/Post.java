package com.AlkemySemana1.ChallengeBackend.entities;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author delam
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Post extends AbstractPersistable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private String content;
    private String image;
    private String category;
    private LocalDate creationDate;
    @ManyToOne
    @JoinColumn(name = "userId")
    private AppUser appUser;

}
