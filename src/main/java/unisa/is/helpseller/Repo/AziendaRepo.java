/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisa.is.helpseller.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import unisa.is.helpseller.Entity.Azienda;

/**
 *
 * @author UTENTE
 */
public interface AziendaRepo extends JpaRepository<Azienda, Integer> {
   @Query("SELECT a FROM Azienda a WHERE a.id = ?1")
   Azienda findId(int id);
   
   @Modifying
   @Query("DELETE FROM Azienda a WHERE a.id = ?1")
   void deleteId(int id);
}
