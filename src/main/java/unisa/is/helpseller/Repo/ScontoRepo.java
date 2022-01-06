/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisa.is.helpseller.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import unisa.is.helpseller.Entity.Sconto;

/**
 *
 * @author UTENTE
 */
public interface ScontoRepo extends JpaRepository<Sconto, Integer> {
   @Query("SELECT s FROM Sconto s WHERE s.id = ?1")
   Sconto findId(int id);
   
   @Modifying
   @Query("DELETE FROM Sconto s WHERE s.id = ?1")
   void deleteId(int id);    
}
