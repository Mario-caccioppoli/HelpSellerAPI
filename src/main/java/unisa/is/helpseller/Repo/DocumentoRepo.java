/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisa.is.helpseller.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import unisa.is.helpseller.Entity.Documento;

/**
 *
 * @author UTENTE
 */
public interface DocumentoRepo extends JpaRepository<Documento, Integer>{
   @Query("SELECT d FROM Documento d WHERE d.id = ?1")
   Documento findId(int id);
   
   @Modifying
   @Query("DELETE FROM Documento d WHERE d.id = ?1")
   void deleteId(int id);
}
