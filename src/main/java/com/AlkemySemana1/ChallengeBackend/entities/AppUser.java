
package com.AlkemySemana1.ChallengeBackend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

public class AppUser extends AbstractPersistable<Long> {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private Long id;
private String email;
private String password;


}

