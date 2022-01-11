package unisa.is.helpseller.Repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import unisa.is.helpseller.Entity.Prodotto;


public interface ProdottoRepo extends JpaRepository<Prodotto, Integer>{
  
    //JPQL
    @Query("SELECT p FROM Prodotto p WHERE p.id = ?1")
   Prodotto findId(int id);
   
   //JPQL
   @Modifying
   @Query("DELETE FROM Prodotto p WHERE p.id = ?1")
   void deleteId(int id);
   
   //SQL
   @Modifying
   @Query(
   value = "INSERT INTO prodotto (nome_prodotto, prezzo, descrizione, quantita, immagine, peso, volume, id_azienda, quantita_minima) "
           + "VALUES (:nome_prodotto, :prezzo, :descrizione, :quantita, :immagine, :peso, :volume, :id_azienda, :quantita_minima)",
           nativeQuery = true)
   void insert(@Param("nome_prodotto") String nome_prodotto, @Param("prezzo") double prezzo, 
           @Param("descrizione") String desccrizione, @Param("quantita") int quantita,
           @Param("immagine") String immagine, @Param("peso") int peso, @Param("volume") int volume,
           @Param("id_azienda") int id_azienda, @Param("quantita_minima") int quantita_minima);
   
   //JPQL
   @Modifying
   @Query("UPDATE Prodotto p SET nome_prodotto = :nome_prodotto, prezzo = :prezzo, descrizione = :descrizione, quantita = :quantita, "
           + "immagine = :immagine, peso = :peso, volume = :volume, id_azienda = :id_azienda, quantita_minima = :quantita_minima WHERE p.id = :id")
   void update(@Param("nome_prodotto") String nome_prodotto, @Param("prezzo") double prezzo, 
           @Param("descrizione") String desccrizione, @Param("quantita") int quantita,
           @Param("immagine") String immagine, @Param("peso") int peso, @Param("volume") int volume,
           @Param("id_azienda") int id_azienda, @Param("quantita_minima") int quantita_minima, @Param("id") int id);
   
   //JPQL
   @Query("SELECT p FROM Prodotto p WHERE p.id_azienda = :id_azienda")
   List<Prodotto> findProdottiByAzienda(@Param("id_azienda") int id_azienda);
   
}
