/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisa.is.helpseller.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import unisa.is.helpseller.Entity.Recensione;

/**
 *
 * @author UTENTE
 */
public interface RecensioneRepo extends JpaRepository<Recensione, Integer>{
    @Query("SELECT r FROM Recensione r WHERE r.id = ?1")
    Recensione findId(int id);
    
    @Modifying
    @Query("DELETE FROM Recensione r WHERE r.id = ?1")
    void deleteId(int id);
}
