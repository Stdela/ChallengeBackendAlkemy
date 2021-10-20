
package com.AlkemySemana1.ChallengeBackend.entities.RequestEntities;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author delam
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestAppUser {
private String email;
private String password;
}
