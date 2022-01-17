package unisa.is.helpseller.Model;


import java.io.Serializable;
import java.sql.Date;
import unisa.is.helpseller.Entity.Documento;

public class DocumentoModel implements Serializable{
    
    private int id;
    private String titolo;
    private String autore;
    private Date data;
    private int idOrdine;
    
    public DocumentoModel() {}

    public DocumentoModel(int id, String titolo, String autore, Date data, int idOrdine) {
        this.id = id;
        this.titolo = titolo;
        this.autore = autore;
        this.data = data;
        this.idOrdine = idOrdine;
    }
    
    public DocumentoModel(Documento d) {
        this.id = d.getId();
        this.titolo = d.getTitolo();
        this.autore = d.getAutore();
        this.data = d.getData();
        this.idOrdine = d.getIdOrdine();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(int idOrdine) {
        this.idOrdine = idOrdine;
    }

    
}