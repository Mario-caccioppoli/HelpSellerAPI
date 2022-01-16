package unisa.is.helpseller.Repo;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import unisa.is.helpseller.Entity.Ordine;


public interface OrdineRepo extends JpaRepository<Ordine, Integer> {
   @Query("SELECT o FROM Ordine o WHERE o.id = ?1")
   Ordine findId(int id);
   
   @Modifying
   @Query("DELETE FROM Ordine o WHERE o.id = ?1")
   int deleteId(int id);
   
   //SQL
   @Modifying
   @Query(
   value = "INSERT INTO ordine (commento, stato, id_distributore, id_ordine_prova, data_consegna, data_ordinazione) "
           + "VALUES (:commento, :stato, :id_distributore, :id_ordine_prova, :data_consegna, :data_ordinazione)",
           nativeQuery = true)
   int insert(@Param("commento") String commento, @Param("stato") String stato, 
           @Param("id_distributore") int id_distributore, 
           @Param("data_consegna") Date data_consegna, @Param("data_ordinazione") Date data_ordinazione);
   
   //JPQL
   @Modifying
   @Query("UPDATE Ordine o SET commento = :commento, stato = :stato, id_distributore = :id_distributore, id_ordine_prova = :id_ordine_prova,"
           + " data_consegna = :data_consegna, data_ordinazione = :data_ordinazione WHERE o.id = :id")
   int update(@Param("commento") String commento, @Param("stato") String stato, @Param("id_distributore") int id_distributore, 
           @Param("data_consegna") Date data_consegna, 
           @Param("data_ordinazione") Date data_ordinazione, @Param("id") int id);
   
     
   //JPQL
   @Query("SELECT o FROM Ordine o WHERE o.id_distributore = :id_distributore")
   List<Ordine> findOrdiniByDistributore(@Param("id_distributore") int id_distributore);
   
   //SQL
   @Query(value = "SELECT DISTINCT ordine.id, ordine.commento, ordine.stato, ordine.id_distributore, ordine.id_ordine_prova, ordine.data_consegna, ordine.data_ordinazione " +
        "FROM prodotto " +
        "INNER JOIN ordine_prodotto AS ordprd " +
        "ON prodotto.id = ordprd.id_prodotto " +
        "INNER JOIN ordine ON ordine.id = ordprd.id_ordine " +
        "WHERE prodotto.id_azienda = :id_azienda", nativeQuery = true)
   List<Ordine> findOrdiniByAzienda(@Param("id_azienda") int id_azienda);
   
   
}
