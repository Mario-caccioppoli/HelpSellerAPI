/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisa.is.helpseller.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import unisa.is.helpseller.Entity.Distributore;

/**
 *
 * @author UTENTE
 */
public interface DistributoreRepo extends JpaRepository<Distributore, Integer>{
   @Query("SELECT d FROM Distributore d WHERE d.id = ?1")
   Distributore findId(int id);
   
   @Modifying
   @Query("DELETE FROM Distributore d WHERE d.id = ?1")
   void deleteId(int id);
}
