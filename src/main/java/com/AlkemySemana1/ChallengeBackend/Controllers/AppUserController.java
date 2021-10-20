/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AlkemySemana1.ChallengeBackend.Controllers;

import com.AlkemySemana1.ChallengeBackend.Services.AppUserService;
import com.AlkemySemana1.ChallengeBackend.entities.AppUser;
import com.AlkemySemana1.ChallengeBackend.entities.RequestEntities.RequestAppUser;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/auth")
public class AppUserController {
    @Autowired
    AppUserService appUserService;
    
    
    @GetMapping()
    public List<Object> list() {
        return null;
    }
    
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        return null;
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        return null;
    }
    
    @PostMapping
    @RequestMapping("/sign_up")
    public AppUser post(@RequestBody RequestAppUser appUser) {
       return appUserService.createAppUser(appUser);
       
        
        
    }
    
    
    // TODO USERLOGIN
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }
    
}