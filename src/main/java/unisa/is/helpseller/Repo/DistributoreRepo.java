package unisa.is.helpseller.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import unisa.is.helpseller.Entity.Distributore;

public interface DistributoreRepo extends JpaRepository<Distributore, Integer>{
   @Query("SELECT d FROM Distributore d WHERE d.id = ?1")
   Distributore findId(int id);
   
   @Modifying
   @Query("DELETE FROM Distributore d WHERE d.id = ?1")
   void deleteId(int id);
   
   //SQL
   @Modifying
   @Query(
   value = "INSERT INTO distributore (username, email, password, nome, cognome, telefono, indirizzo_sede, id_ordine_prova, vat) "
           +  "VALUES (:username, :email, "
           + ":password, :nome, :cognome, :telefono, :indirizzo_sede, :id_ordine_prova, :vat)",
           nativeQuery = true)
   void insert(@Param("username") String username, @Param("email") String email, 
           @Param("password") String password, @Param("nome") String nome, 
           @Param("cognome") String cognome, @Param("telefono") String telefono, 
           @Param("indirizzo_sede") String indirizzo_sede, 
           @Param("id_ordine_prova") int id_ordine_prova, @Param("vat") String vat);
   
   //JPQL
   @Modifying
   @Query("UPDATE Distributore d SET password = :value WHERE d.id = :id")
   void updatePassword (@Param("value") String value, @Param("id") int id);
}
