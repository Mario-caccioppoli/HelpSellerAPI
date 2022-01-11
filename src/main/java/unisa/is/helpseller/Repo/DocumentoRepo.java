package unisa.is.helpseller.Repo;

import java.sql.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import unisa.is.helpseller.Entity.Documento;


public interface DocumentoRepo extends JpaRepository<Documento, Integer>{
   //JPQL
   @Query("SELECT d FROM Documento d WHERE d.id = ?1")
   Documento findId(int id);
   
   //JPQL
   @Modifying
   @Query("DELETE FROM Documento d WHERE d.id = ?1")
   void deleteId(int id);
   
   //SQL
   @Modifying
   @Query(
   value = "INSERT INTO documento (titolo, autore, id_ordine, data) VALUES (:titolo, :autore, :id_ordine, :data)",
           nativeQuery = true)
   void insert(@Param("titolo") String titolo, @Param("autore") String autore, @Param("id_ordine") int idOrdine, @Param("data") Date data);
   
   //JPQL
   @Modifying
   @Query("UPDATE Documento d SET titolo = :titolo, autore = :autore, id_ordine = :id_ordine, data = :data WHERE d.id = :id")
   void update(@Param("titolo") String titolo, @Param("autore") String autore, @Param("id_ordine") int id_ordine, @Param("data") Date data, @Param("id") int id);
   
}
