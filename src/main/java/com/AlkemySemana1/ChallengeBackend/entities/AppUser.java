
package com.AlkemySemana1.ChallengeBackend.entities;

import javax.persistence.Entity;
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

private String email;
private String password;
}
