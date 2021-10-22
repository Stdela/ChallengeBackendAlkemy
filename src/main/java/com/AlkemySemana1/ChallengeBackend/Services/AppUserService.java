package com.AlkemySemana1.ChallengeBackend.Services;

import com.AlkemySemana1.ChallengeBackend.Repositories.AppUserRepository;
import com.AlkemySemana1.ChallengeBackend.entities.AppUser;
import com.AlkemySemana1.ChallengeBackend.entities.RequestEntities.RequestAppUser;
import java.util.Arrays;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author delam
 */
@Service
@Transactional

public class AppUserService {

    @Autowired
    AppUserRepository userRepository;
    @Autowired
    PasswordEncoder passEncoder;

    public AppUser createAppUser(RequestAppUser userRequest) {
        if (userRepository.findByEmail(userRequest.getEmail()) != null) {
            throw new IllegalArgumentException("User already exists");
        }

        AppUser user = new AppUser();
        user.setEmail(userRequest.getEmail());

        user.setPassword(passEncoder.encode(userRequest.getPassword()));
        userRepository.save(user);
        return user;

    }

    

}
