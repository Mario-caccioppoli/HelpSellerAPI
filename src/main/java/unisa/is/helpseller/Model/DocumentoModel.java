package unisa.is.helpseller.Model;


import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;

public class DocumentoModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private int idDocumento;
    private String titolo;
    private String autore;
    private Date dataUpload;
    private int idOrdine;
    
    public DocumentoModel() {}

    public DocumentoModel(String titolo, String autore, Date data, int idOrdine) {
        this.titolo = titolo;
        this.autore = autore;
        this.dataUpload = data;
        this.idOrdine = idOrdine;
    }

    public long getId() {
        return id;
    }

    public int getIdDocumento() {
        return idDocumento;
    }
    

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public Date getData() {
        return dataUpload;
    }

    public void setData(Date data) {
        this.dataUpload = data;
    }

    public int getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(int idOrdine) {
        this.idOrdine = idOrdine;
    }
    
    
}