
package com.AlkemySemana1.ChallengeBackend.Security.Filter;

import com.AlkemySemana1.ChallengeBackend.Repositories.AppUserRepository;
import com.AlkemySemana1.ChallengeBackend.entities.AppUser;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author delam
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {
 
    @Autowired
    AppUserRepository userRepository;
//    @Autowired
//    PasswordEncoder passEncoder;
    
    
    
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        if (userRepository.findByEmail(email) == null) {
            throw new UsernameNotFoundException("User does not exist: " + email);
        }
        AppUser appuser = userRepository.findByEmail(email);

        return new org.springframework.security.core.userdetails.User(
                appuser.getEmail(),
                appuser.getPassword(),
                true,
                true,
                true,
                true,
                Arrays.asList(new SimpleGrantedAuthority("USER")));

    }
}
