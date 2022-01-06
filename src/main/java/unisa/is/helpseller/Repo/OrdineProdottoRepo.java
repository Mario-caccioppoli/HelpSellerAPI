/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisa.is.helpseller.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import unisa.is.helpseller.Entity.OrdineProdotto;

/**
 *
 * @author UTENTE
 */
public interface OrdineProdottoRepo extends JpaRepository<OrdineProdotto, Integer> {
   @Query("SELECT o FROM OrdineProdotto o WHERE o.id = ?1")
   OrdineProdotto findId(int id);
   
   @Modifying
   @Query("DELETE FROM OrdineProdotto o WHERE o.id = ?1")
   void deleteId(int id);
}
