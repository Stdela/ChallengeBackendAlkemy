/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AlkemySemana1.ChallengeBackend.Controllers;

import com.AlkemySemana1.ChallengeBackend.Security.Filter.JwtResponse;
import com.AlkemySemana1.ChallengeBackend.Security.Filter.JwtTokenUtil;
import com.AlkemySemana1.ChallengeBackend.Security.Filter.JwtUserDetailsService;
import com.AlkemySemana1.ChallengeBackend.Services.AppUserService;
import com.AlkemySemana1.ChallengeBackend.entities.AppUser;
import com.AlkemySemana1.ChallengeBackend.entities.RequestEntities.RequestAppUser;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author delam
 */
@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AppUserController {
    
    @Autowired
    AppUserService appUserService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @PostMapping
    @RequestMapping("/sign_up")
    public ResponseEntity<?> registerUser(@RequestBody RequestAppUser appUser) {
        
        appUserService.createAppUser(appUser);
        return ResponseEntity.ok("User created");
    }
    
    @PostMapping
    @RequestMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AppUser authenticationRequest) throws Exception {
        
        authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());
        
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);
        
        return ResponseEntity.ok(new JwtResponse(token));
    }
    
    private void authenticate(String mail, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(mail, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
    
}
