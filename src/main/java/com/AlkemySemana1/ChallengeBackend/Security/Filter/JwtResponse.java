package com.AlkemySemana1.ChallengeBackend.Security.Filter;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author delam
 */
@Data
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;

    

}
