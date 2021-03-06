package unisa.is.helpseller.Repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import unisa.is.helpseller.Entity.Azienda;

/**
 * classe repo dove vengono definire le query per la gestione ed interrogazione dell'entità Azienda del db
 */
public interface AziendaRepo extends JpaRepository<Azienda, Integer> {
   @Query("SELECT a FROM Azienda a WHERE a.id = ?1")
   Azienda findId(int id);
   
   @Modifying
   @Query("DELETE FROM Azienda a WHERE a.id = ?1")
   int deleteId(int id);
   
   //SQL
   @Modifying
   @Query(
   value = "INSERT INTO azienda (email, password, nome_azienda, indirizzo, vat, "
           + "descrizione, logo) VALUES (:email, :password, "
           + ":nome_azienda, :indirizzo, :vat, :descrizione, :logo)",
           nativeQuery = true)
   int insert(@Param("email") String email, @Param("password") String password, 
           @Param("nome_azienda") String nome_azienda, 
           @Param("indirizzo") String indirizzo, @Param("vat") String vat,
           @Param("descrizione") String descrizione, @Param("logo") String logo);
   
   //JPQL
   @Modifying
   @Query("UPDATE Azienda a SET email = :email, password = :password, nome_azienda = :nome_azienda, indirizzo = :indirizzo, "
           + "vat = :vat, descrizione = :descrizione, logo = :logo WHERE a.id = :id")
   int update(@Param("email") String email, @Param("password") String password, 
           @Param("nome_azienda") String nome_azienda, 
           @Param("indirizzo") String indirizzo, @Param("vat") String vat,
           @Param("descrizione") String descrizione, @Param("logo") String logo, @Param("id") int id);
   
   //JPQL
   @Query("SELECT a FROM Azienda a WHERE a.nome_azienda LIKE %:nome_azienda%")
   List<Azienda> findAziendeByNome(@Param("nome_azienda") String nome_azienda);
   
   //SQL
   @Query(
   value ="SELECT azienda.id, azienda.email, azienda.password, azienda.nome_azienda, azienda.vat, azienda.indirizzo, azienda.descrizione, azienda.logo " +
    "FROM azienda " +
    "INNER JOIN prodotto " +
    "ON prodotto.id_azienda = azienda.id " +
    "WHERE prodotto.id = :id_prodotto", nativeQuery = true)
   Azienda findAziendaByProdotto(@Param("id_prodotto") int id_prodotto);
   
   //JPQL
   @Query("SELECT a.password FROM Azienda a WHERE a.email = :email")
   String recuperoPassword(@Param("email") String email);
}
