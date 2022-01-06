/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisa.is.helpseller.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import unisa.is.helpseller.Entity.Ordine;

/**
 *
 * @author UTENTE
 */
public interface OrdineRepo extends JpaRepository<Ordine, Integer> {
   @Query("SELECT o FROM Ordine o WHERE o.id = ?1")
   Ordine findId(int id);
   
   @Modifying
   @Query("DELETE FROM Ordine o WHERE o.id = ?1")
   void deleteId(int id);
}
