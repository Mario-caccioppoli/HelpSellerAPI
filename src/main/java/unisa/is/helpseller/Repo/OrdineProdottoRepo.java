package unisa.is.helpseller.Repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Pair;
import unisa.is.helpseller.Entity.OrdineProdotto;
import unisa.is.helpseller.Entity.Prodotto;

public interface OrdineProdottoRepo extends JpaRepository<OrdineProdotto, Integer> {

    @Query("SELECT o FROM OrdineProdotto o WHERE o.id_ordine = ?1 AND o.id_prodotto = ?2")
    OrdineProdotto findId(int id_ordine, int id_prodotto);

    @Modifying
    @Query("DELETE FROM OrdineProdotto o WHERE o.id_ordine = ?1 AND o.id_prodotto = ?2")
    int deleteId(int id_ordine, int id_prodotto);

    //SQL
    @Modifying
    @Query(
            value = "INSERT INTO ordine_prodotto (id_ordine, id_prodotto, quantita, prezzo, prezzo_unitario) VALUES (:id_ordine, :id_prodotto, :quantita, :prezzo, :prezzo_unitario)",
            nativeQuery = true)
    int insert(@Param("id_ordine") int id_ordine, @Param("id_prodotto") int id_prodotto,
            @Param("quantita") int quantita, @Param("prezzo") double prezzo, @Param("prezzo_unitario") double prezzo_unitario);

    //JPQL
    @Modifying
    @Query("UPDATE OrdineProdotto o SET quantita = :quantita, "
            + "prezzo = :prezzo, prezzo_unitario = :prezzo_unitario WHERE o.id_ordine = :id_ordine AND o.id_prodotto = :id_prodotto")
    int update(@Param("id_ordine") int id_ordine, @Param("id_prodotto") int id_prodotto,
            @Param("quantita") int quantita, @Param("prezzo") double prezzo,
            @Param("prezzo_unitario") double prezzo_unitario);

    //SQL
    @Query(
            value = "SELECT ordine_prodotto.* "
            + "FROM ordine_prodotto "
            + "INNER JOIN prodotto "
            + "ON ordine_prodotto.id_prodotto = prodotto.id "
            + "WHERE ordine_prodotto.id_ordine = :id_ordine", nativeQuery = true)
    List<OrdineProdotto> findDettagliOrdine(@Param("id_ordine") int id_ordine);

    //SQL
    /*@Query(
            value = "SELECT prodotto.* "
            + "FROM ordine_prodotto "
            + "INNER JOIN prodotto "
            + "ON ordine_prodotto.id_prodotto = prodotto.id "
            + "WHERE ordine_prodotto.id_ordine = :id_ordine", nativeQuery = true)
    List<Prodotto> findDettagliProdotto(@Param("id_ordine") int id_ordine);
    */
    
    //JPQL
    @Query("SELECT p FROM Prodotto p, OrdineProdotto op "
            + "WHERE op.id_prodotto = p.id AND op.id_ordine = :id_ordine")
    List<Prodotto> findDettagliProdotto(@Param("id_ordine") int id_ordine);
    
    //JPQL
    @Query("SELECT p, op FROM Prodotto p, OrdineProdotto op "
            + "WHERE op.id_prodotto = p.id AND op.id_ordine = :id_ordine")
    List<Object[]> findDettagliOrdineProdotto(@Param("id_ordine") int id_ordine);
    
    //SQL
    @Query(value = "SELECT SUM(prezzo_ordine) FROM ordine_prodotto INNER JOIN ordine ON id_ordine=ordine.id WHERE year(ordine.data_ordinazione) = :anno", 
            nativeQuery = true)
    Integer findReportAnnuale(@Param("anno") Integer anno);
    
    //SQL
    @Query(value = "SELECT SUM(prezzo_ordine) FROM ordine_prodotto INNER JOIN ordine ON id_ordine=ordine.id INNER JOIN prodotto ON id_prodotto=prodotto.id "
            + "WHERE month(ordine.data_ordinazione) = :mese AND year(ordine.data_ordinazione) = :anno AND prodotto.id_azienda = :id_azienda", nativeQuery = true)
    Integer findReportMensile(@Param("mese") String mese, @Param("anno") Integer anno, @Param("id_azienda") Integer id_azienda);
    
    //SQL
    @Query(value = "SELECT SUM(prezzo_ordine) FROM ordine_prodotto INNER JOIN ordine ON id_ordine=ordine.id INNER JOIN prodotto ON id_prodotto=prodotto.id "
            + "WHERE year(ordine.data_ordinazione) = :anno AND prodotto.id_azienda = :id_azienda", 
            nativeQuery = true)
    Integer findReportAnnualeAzienda(@Param("anno") Integer anno, @Param("id_azienda") Integer id_azienda);
    
    //SQL
    @Query(value = "SELECT SUM(prezzo_ordine) FROM ordine_prodotto INNER JOIN ordine ON id_ordine=ordine.id  "
            + "WHERE month(ordine.data_ordinazione) = :mese AND year(ordine.data_ordinazione) = :anno", nativeQuery = true)
    Integer findReportMensileGruppo(@Param("mese") String mese, @Param("anno") Integer anno);
}
