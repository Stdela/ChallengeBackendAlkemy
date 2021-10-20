
package com.AlkemySemana1.ChallengeBackend.entities.updateEntities;

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
public class UpdatePost {
private String title;
private String content;
private String image;
private String category;
}
