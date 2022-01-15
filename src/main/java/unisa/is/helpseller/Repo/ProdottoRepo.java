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
   
   //JPQL
   @Query("SELECT p FROM Prodotto p WHERE p.nome_prodotto LIKE %:nome_prodotto%")
   List<Prodotto> findProdottiByNome(@Param("nome_prodotto") String nome_prodotto);
   
   //JPQL
   @Query("SELECT p FROM Prodotto p WHERE p.nome_prodotto LIKE %:nome_prodotto% AND p.id_azienda = :id_azienda")
   List<Prodotto> findProdottiByNomeInAzienda(@Param("nome_prodotto") String nome_prodotto, @Param("id_azienda") int id_azienda);
   
   //SQL
   @Query(value = "SELECT * " +
        "FROM prodotto " +
        "INNER JOIN ordine_prodotto AS ordprd " +
        "ON prodotto.id = ordprd.id_prodotto " +
        "WHERE ordprd.id_ordine = :id_ordine", nativeQuery = true)
   List<Prodotto> findProdottiInOrdine(@Param("id_ordine") int id_ordine);
   
   //JPQL
   @Query("SELECT p FROM Prodotto p, ScontoProdotto sp "
            + "WHERE sp.id_prodotto = p.id AND sp.id_sconto = :id_sconto")
   List<Prodotto> findProdottiBySconto(@Param("id_sconto") int id_sconto);
   
}
