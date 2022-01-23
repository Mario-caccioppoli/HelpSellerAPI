package unisa.is.helpseller.Repo;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import unisa.is.helpseller.Entity.Sconto;

/**
 * classe repo dove vengono definire le query per la gestione ed interrogazione dell'entità Sconto del db
 */
public interface ScontoRepo extends JpaRepository<Sconto, Integer> {
   @Query("SELECT s FROM Sconto s WHERE s.id = ?1")
   Sconto findId(int id);
   
   @Modifying
   @Query("DELETE FROM Sconto s WHERE s.id = ?1")
   int deleteId(int id);
   
   //SQL
   @Modifying
   @Query(
   value = "INSERT INTO sconto (nome_sconto, percentuale, tipo, quantita, id_azienda, data_fine, data_inizio) "
           + "VALUES (:nome_sconto, :percentuale, :tipo, :quantita, :id_azienda, :data_fine, :data_inizio)",
           nativeQuery = true)
   int insert(@Param("nome_sconto") String nome_sconto, @Param("percentuale") int percentuale, @Param("tipo") String tipo, @Param("quantita") Integer quantita, 
           @Param("id_azienda") int id_azienda, @Param("data_fine") Date data_fine, @Param("data_inizio") Date data_inizio);
   
   //JPQL
   @Modifying
   @Query("UPDATE Sconto s SET nome_sconto = :nome_sconto, percentuale = :percentuale, tipo = :tipo, quantita = :quantita, "
           + "id_azienda = :id_azienda, data_fine = :data_fine, data_inizio = :data_inizio WHERE s.id = :id")
   int update(@Param("nome_sconto") String nome_sconto, @Param("percentuale") int percentuale, @Param("tipo") String tipo, @Param("quantita") Integer quantita, 
           @Param("id_azienda") int id_azienda, @Param("data_fine") Date data_fine, @Param("data_inizio") Date data_inizio,
            @Param("id") int id);
   
   //JPQL
   @Query("SELECT s FROM Sconto s WHERE s.id_azienda = :id_azienda")
   List<Sconto> findScontiByAzienda(@Param("id_azienda") int id_azienda);
   
   //JPQL
   @Query("SELECT s FROM Sconto s WHERE s.tipo = :tipo")
   List<Sconto> findScontiByTipo(@Param("tipo") String tipo);
   
   //JPQL
   @Query("SELECT s FROM Sconto s WHERE s.tipo = :tipo AND s.id_azienda = :id_azienda")
   List<Sconto> findScontiAziendaByTipo(@Param("tipo") String tipo, @Param("id_azienda") int id_azienda);
   
   //JPQL
   @Query("SELECT s FROM Sconto s, Azienda a WHERE s.nome_sconto LIKE %:nome_sconto% AND a.id = :id_azienda")
   List<Sconto> findScontiByNomeInAzienda(@Param("nome_sconto") String nome_sconto, @Param("id_azienda") int id_azienda);
}
