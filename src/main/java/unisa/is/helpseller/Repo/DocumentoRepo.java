/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisa.is.helpseller.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import unisa.is.helpseller.Model.Documento;

/**
 *
 * @author UTENTE
 */
public interface DocumentoRepo extends JpaRepository<Documento, Long>{
    
}
