
package unisa.is.helpseller.Repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import unisa.is.helpseller.Entity.ScontoProdotto;

/**
 * classe repo dove vengono definire le query per la gestione ed interrogazione dell'entità ScontoProdotto del db
 */
public interface ScontoProdottoRepo extends JpaRepository<ScontoProdotto, Integer>{
   @Query(value = "SELECT * FROM sconto_prodotto", nativeQuery = true)
   List<ScontoProdotto> findAllScontoProdotto();
    
   @Query("SELECT sp FROM ScontoProdotto sp WHERE sp.id_sconto = ?1")
   List<ScontoProdotto> findBySconto(int id);
   
   @Query("SELECT sp FROM ScontoProdotto sp WHERE sp.id_prodotto = ?1")
   List<ScontoProdotto> findByProdotto(int id);
   
   @Modifying
   @Query("DELETE FROM ScontoProdotto sp WHERE sp.id_prodotto = :id_prodotto AND sp.id_sconto = :id_sconto")
   int deleteId(@Param("id_prodotto") int id_prodotto, @Param("id_sconto") int id_sconto);
   
   //SQL
   @Modifying
   @Query(
   value = "INSERT INTO sconto_prodotto (id_sconto, id_prodotto) VALUES (:id_sconto, :id_prodotto)",
           nativeQuery = true)
   int insert(@Param("id_sconto") int id_sconto, @Param("id_prodotto") int id_prodotto);
   
   //JPQL
   @Modifying
   @Query("UPDATE ScontoProdotto s SET id_sconto = :id_sconto, id_prodotto = :id_prodotto WHERE s.id_sconto = :id_sconto_old AND s.id_prodotto = :id_prodotto_old")
   int update(@Param("id_sconto") int id_sconto, @Param("id_prodotto") int id_prodotto, @Param("id_sconto_old") int id_sconto_old, @Param("id_prodotto_old") int id_prodotto_old);
   
   //JPQL
   @Query("SELECT p, s FROM Prodotto p, Sconto s, ScontoProdotto sp "
           + "WHERE sp.id_prodotto = p.id AND sp.id_sconto = s.id AND p.nome_prodotto LIKE %:nome_prodotto% AND p.id_azienda = :id_azienda")
   List<Object[]> findProdottiScontatiAzienda(@Param("nome_prodotto") String nome_prodotto, @Param("id_azienda") int id_azienda);
}
