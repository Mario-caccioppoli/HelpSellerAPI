/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisa.is.helpseller.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import unisa.is.helpseller.Entity.Amministratore;
/**
 *
 * @author UTENTE
 */
public interface AmministratoreRepo extends JpaRepository<Amministratore, Long> {
    
}
