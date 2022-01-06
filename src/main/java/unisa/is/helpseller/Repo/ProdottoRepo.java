/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisa.is.helpseller.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import unisa.is.helpseller.Entity.Amministratore;
import unisa.is.helpseller.Entity.Prodotto;

/**
 *
 * @author UTENTE
 */
public interface ProdottoRepo extends JpaRepository<Prodotto, Integer>{
   @Query("SELECT p FROM Prodotto p WHERE p.id = ?1")
   Prodotto findId(int id);
   
   @Modifying
   @Query("DELETE FROM Prodotto p WHERE p.id = ?1")
   void deleteId(int id);
}
