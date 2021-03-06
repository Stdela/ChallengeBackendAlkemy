
package com.AlkemySemana1.ChallengeBackend.entities.RequestEntities;

import com.AlkemySemana1.ChallengeBackend.entities.AppUser;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class RequestPost {
private String title;
private String content;
private String image;
private String category;
private LocalDate creationDate;
//@ManyToOne
//@JoinColumn(name = "userId")
//private AppUser appUser;

}
