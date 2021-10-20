
package com.AlkemySemana1.ChallengeBackend.Services;

import com.AlkemySemana1.ChallengeBackend.Repositories.AppUserRepository;
import com.AlkemySemana1.ChallengeBackend.entities.AppUser;
import com.AlkemySemana1.ChallengeBackend.entities.RequestEntities.RequestAppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author delam
 */
@Service
public class AppUserService {
@Autowired
AppUserRepository userRepository;

private AppUser createAppUser(@RequestBody RequestAppUser userRequest ){
    AppUser user = new AppUser();
    user.setEmail(userRequest.getEmail());
    user.setPassword(userRequest.getPassword());
    userRepository.save(user);
    return user;
    
}

}
