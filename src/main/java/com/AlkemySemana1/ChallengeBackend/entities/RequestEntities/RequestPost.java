
package com.AlkemySemana1.ChallengeBackend.entities.RequestEntities;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author delam
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestPost {
    private Long id;
private String email;
private String password;

}
