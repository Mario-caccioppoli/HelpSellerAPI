package unisa.is.helpseller.Repo;

import java.sql.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import unisa.is.helpseller.Entity.Recensione;

public interface RecensioneRepo extends JpaRepository<Recensione, Integer>{
    @Query("SELECT r FROM Recensione r WHERE r.id = ?1")
    Recensione findId(int id);
    
    @Modifying
    @Query("DELETE FROM Recensione r WHERE r.id = ?1")
    void deleteId(int id);
    
   //SQL
   @Modifying
   @Query(
   value = "INSERT INTO recensione (testo, voto, data, id_prodotto, id_distributore) VALUES (:testo, :voto, :data, :id_prodotto, :id_distributore)",
           nativeQuery = true)
   void insert(@Param("testo") String testo, @Param("voto") int voto, @Param("data") Date data, 
           @Param("id_prodotto") int id_prodotto, @Param("id_distributore") int id_distributore);
   
   //JPQL
   @Modifying
   @Query("UPDATE Recensione r SET testo = :testo, voto = :voto, data = :data, id_prodotto = :id_prodotto, id_distributore = :id_distributore WHERE r.id = :id")
   void update(@Param("testo") String testo, @Param("voto") int voto, @Param("data") Date data, 
           @Param("id_prodotto") int id_prodotto, @Param("id_distributore") int id_distributore, @Param("id") int id);
}
