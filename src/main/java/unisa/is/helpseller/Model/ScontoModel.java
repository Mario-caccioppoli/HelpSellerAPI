package unisa.is.helpseller.Model;


import java.sql.Date;
import java.util.List;
import java.io.Serializable;
import javax.persistence.*;


public class ScontoModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int percentuale;
    private Date dataInizio;
    private Date dataFine;
    private String tipo;
    private int quantita;
    private int idAzienda;
    private List<ProdottoModel> prodotti;

    public ScontoModel() {}

    public ScontoModel(int percentuale, Date dataInizio, Date dataFine, String tipo, int quantita, int idAzienda) {
        this.percentuale = percentuale;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.tipo = tipo;
        this.quantita = quantita;
        this.idAzienda = idAzienda;
    }

    public long getId() {
        return id;
    }

    public int getPercentuale() {
        return percentuale;
    }

    public void setPercentuale(int percentuale) {
        this.percentuale = percentuale;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public int getIdAzienda() {
        return idAzienda;
    }

    public void setIdAzienda(int idAzienda) {
        this.idAzienda = idAzienda;
    }

}