package unisa.is.helpseller.Repo;

import java.sql.Date;
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
   void deleteId(int id);
   
   //SQL
   @Modifying
   @Query(
   value = "INSERT INTO ordine (commento, stato, id_distributore, id_ordine_prova, data_consegna, data_ordinazione) "
           + "VALUES (:commento, :stato, :id_distributore, :id_ordine_prova, :data_consegna, :data_ordinazione)",
           nativeQuery = true)
   void insert(@Param("commento") String commento, @Param("stato") String stato, 
           @Param("id_distributore") int id_distributore, @Param("id_ordine_prova") int id_ordine_prova, 
           @Param("data_consegna") Date data_consegna, @Param("data_ordinazione") Date data_ordinazione);
   
   //JPQL
   @Modifying
   @Query("UPDATE Ordine o SET commento = :commento, stato = :stato, id_distributore = :id_distributore, id_ordine_prova = :id_ordine_prova,"
           + " data_consegna = :data_consegna, data_ordinazione = :data_ordinazione WHERE o.id = :id")
   void update(@Param("commento") String commento, @Param("stato") String stato, @Param("id_distributore") int id_distributore, 
           @Param("id_ordine_prova") int id_ordine_prova, @Param("data_consegna") Date data_consegna, 
           @Param("data_ordinazione") Date data_ordinazione, @Param("id") int id);
   
  
}
