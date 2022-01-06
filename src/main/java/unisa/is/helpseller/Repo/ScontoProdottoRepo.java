/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisa.is.helpseller.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import unisa.is.helpseller.Entity.ScontoProdotto;

/**
 *
 * @author UTENTE
 */
public interface ScontoProdottoRepo extends JpaRepository<ScontoProdotto, Integer>{
   @Query("SELECT sp FROM ScontoProdotto sp WHERE sp.id = ?1")
   ScontoProdotto findId(int id);
   
   @Modifying
   @Query("DELETE FROM ScontoProdotto sp WHERE sp.id = ?1")
   void deleteId(int id);
}
