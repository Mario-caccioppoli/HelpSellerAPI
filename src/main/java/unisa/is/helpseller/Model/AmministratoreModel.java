package unisa.is.helpseller.Model;


import java.io.Serializable;


public class AmministratoreModel implements Serializable{
 
    private int id;
    private String username;
    private String email;
    private String password;
    
    public AmministratoreModel() {}
    
    public AmministratoreModel(int id, String email, String username, String password) {
    	this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
       
}
