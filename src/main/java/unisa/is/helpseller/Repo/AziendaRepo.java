/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisa.is.helpseller.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
   
   //SQL
   @Modifying
   @Query(
   value = "INSERT INTO azienda (email, password, nome_azienda, indirizzo, vat, "
           + "descrizione, logo) VALUES (:email, :password, "
           + ":nome_azienda, :indirizzo, :vat, :descrizione, :logo)",
           nativeQuery = true)
   void insert(@Param("email") String email, @Param("password") String password, 
           @Param("nome_azienda") String nome_azienda, 
           @Param("indirizzo") String indirizzo, @Param("vat") String vat,
           @Param("descrizione") String descrizione, @Param("logo") String logo);
   
   //JPQL
   @Modifying
   @Query("UPDATE Azienda a SET password = :value WHERE a.id = :id")
   void updatePassword (@Param("value") String value, @Param("id") int id);
}
