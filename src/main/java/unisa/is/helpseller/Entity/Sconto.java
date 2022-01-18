package unisa.is.helpseller.Entity;


import java.sql.Date;
import java.io.Serializable;
import javax.persistence.*;
import unisa.is.helpseller.Model.ScontoModel;


@Entity
@Table(name = "sconto")
public class Sconto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome_sconto;
    private int percentuale;
    private Date data_inizio;
    private Date data_fine;
    private String tipo;
    private Integer quantita;
    private int id_azienda;


    public Sconto() {}

    public Sconto(String nome_sconto, int percentuale, Date data_inizio, 
            Date data_fine, String tipo, int quantita, int id_azienda) {
        this.nome_sconto = nome_sconto;
        this.percentuale = percentuale;
        this.data_inizio = data_inizio;
        this.data_fine = data_fine;
        this.tipo = tipo;
        this.quantita = quantita;
        this.id_azienda = id_azienda;
    }
    
    public Sconto(ScontoModel s) {
        this.id = s.getId();
        this.nome_sconto = s.getNome();
        this.percentuale = s.getPercentuale();
        this.data_inizio = s.getDataInizio();
        this.data_fine = s.getDataFine();
        this.tipo = s.getTipo();
        this.quantita = s.getQuantita();
        this.id_azienda = s.getIdAzienda();
    }

    public int getId() {
        return id;
    }

    public int getPercentuale() {
        return percentuale;
    }

    public void setPercentuale(int percentuale) {
        this.percentuale = percentuale;
    }

    public Date getDataInizio() {
        return data_inizio;
    }

    public void setDataInizio(Date data_inizio) {
        this.data_inizio = data_inizio;
    }

    public Date getDataFine() {
        return data_fine;
    }

    public void setDataFine(Date data_fine) {
        this.data_fine = data_fine;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    public int getIdAzienda() {
        return id_azienda;
    }

    public void setIdAzienda(int id_azienda) {
        this.id_azienda = id_azienda;
    }

    public String getNome() {
        return nome_sconto;
    }

    public void setNome(String nome_sconto) {
        this.nome_sconto = nome_sconto;
    }

}
