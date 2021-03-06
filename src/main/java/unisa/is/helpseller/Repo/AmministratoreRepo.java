
package unisa.is.helpseller.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import unisa.is.helpseller.Entity.Amministratore;

/**
 * classe repo dove vengono definire le query per la gestione ed interrogazione dell'entità Amministratore del db
 */
public interface AmministratoreRepo extends JpaRepository<Amministratore, Integer> {
   
    //JPQL
    @Query("SELECT a FROM Amministratore a WHERE a.id = ?1")
   Amministratore findId(int id);
   
   //JPQL
   @Modifying
   @Query("DELETE FROM Amministratore a WHERE a.id = ?1")
   int deleteId(int id);
   
   //SQL
   @Modifying
   @Query(
   value = "INSERT INTO amministratore (username, email, password) VALUES (:username, :email, :password)",
           nativeQuery = true)
   int insert(@Param("username") String username, @Param("email") String email, @Param("password") String password);
   
   //JPQL
   @Modifying
   @Query("UPDATE Amministratore a SET username = :username, email = :email, password = :password WHERE a.id = :id")
   int update(@Param("username") String username, @Param("email") String email, @Param("password") String password, @Param("id") int id);
   
   //JPQL
   @Query("SELECT a.password FROM Amministratore a WHERE a.email = :email")
   String recuperoPassword(@Param("email") String email);
}
