package unisa.is.helpseller.Repo;

import java.sql.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import unisa.is.helpseller.Entity.OrdineProdotto;


public interface OrdineProdottoRepo extends JpaRepository<OrdineProdotto, Integer> {
   @Query("SELECT o FROM OrdineProdotto o WHERE o.id_ordine = ?1 AND o.id_prodotto = ?2")
   OrdineProdotto findId(int id_ordine, int id_prodotto);
   
   @Modifying
   @Query("DELETE FROM OrdineProdotto o WHERE o.id_ordine = ?1 AND o.id_prodotto = ?2")
   void deleteId(int id_ordine, int id_prodotto);
   
   //SQL
   @Modifying
   @Query(
   value = "INSERT INTO ordine_prodotto (id_ordine, id_prodotto, quantita, prezzo, prezzo_unitario) VALUES (:id_ordine, :id_prodotto, :quantita, :prezzo, :prezzo_unitario)",
           nativeQuery = true)
   void insert(@Param("id_ordine") int id_ordine, @Param("id_prodotto") int id_prodotto, 
           @Param("quantita") int quantita, @Param("prezzo") double prezzo, @Param("prezzo_unitario") double prezzo_unitario);
   
   //JPQL
   @Modifying
   @Query("UPDATE OrdineProdotto o SET quantita = :quantita, "
           + "prezzo = :prezzo, prezzo_unitario = :prezzo_unitario WHERE o.id_ordine = :id_ordine AND o.id_prodotto = :id_prodotto")
   void update(@Param("id_ordine") int id_ordine, @Param("id_prodotto") int id_prodotto, 
           @Param("quantita") int quantita, @Param("prezzo") double prezzo, 
           @Param("prezzo_unitario") double prezzo_unitario);
   
}
