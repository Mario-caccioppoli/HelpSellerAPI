package unisa.is.helpseller.Repo;

import java.sql.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import unisa.is.helpseller.Entity.Trasporto;

public interface TrasportoRepo extends JpaRepository<Trasporto, Integer> {
   @Query("SELECT t FROM Trasporto t WHERE t.id = ?1")
   Trasporto findId(int id);
   
   @Modifying
   @Query("DELETE FROM Trasporto t WHERE t.id = ?1")
   int deleteId(int id);
   
   //SQL
   @Modifying
   @Query(
   value = "INSERT INTO trasporto (id_ordine, data_consegna, indirizzo_consegna, quantita_minima) VALUES (:id_ordine, :data_consegna, :indirizzo_consegna, :quantita_minima)",
           nativeQuery = true)
   int insert(@Param("id_ordine") int id_ordine, @Param("data_consegna") Date data_consegna, @Param("indirizzo_consegna") String indirizzo_consegna, 
           @Param("quantita_minima") int quantita_minima);
   
   //JPQL
   @Modifying
   @Query("UPDATE Trasporto t SET id_ordine = :id_ordine, data_consegna = :data_consegna, indirizzo_consegna = :indirizzo_consegna, "
           + "quantita_minima = :quantita_minima WHERE t.id = :id")
   int update(@Param("id_ordine") int id_ordine, @Param("data_consegna") Date data_consegna, @Param("indirizzo_consegna") String indirizzo_consegna, 
           @Param("quantita_minima") int quantita_minima, @Param("id") int id);
}
