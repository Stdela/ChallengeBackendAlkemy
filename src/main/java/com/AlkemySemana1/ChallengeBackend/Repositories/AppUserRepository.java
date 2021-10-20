/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AlkemySemana1.ChallengeBackend.Repositories;

import com.AlkemySemana1.ChallengeBackend.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author delam
 */
public interface AppUserRepository extends JpaRepository<AppUser,Long>{
    AppUser findByEmail(String email);
   
}
