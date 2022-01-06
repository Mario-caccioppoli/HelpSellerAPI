/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisa.is.helpseller.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import unisa.is.helpseller.Entity.Trasporto;

/**
 *
 * @author UTENTE
 */
public interface TrasportoRepo extends JpaRepository<Trasporto, Integer> {
   @Query("SELECT t FROM Trasporto t WHERE t.id = ?1")
   Trasporto findId(int id);
   
   @Modifying
   @Query("DELETE FROM Trasporto t WHERE t.id = ?1")
   void deleteId(int id);
}
