/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import unisa.is.helpseller.Model.OrdineProdotto;

/**
 *
 * @author UTENTE
 */
public interface OrdineProdottoRepo extends JpaRepository<OrdineProdotto, Long> {
    
}
