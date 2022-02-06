package unisa.is.helpseller.Model;


import java.sql.Date;
import java.util.List;
import java.io.Serializable;
import unisa.is.helpseller.Entity.Sconto;

/**
 * Classe model utilizzata per la comunicazione col frontend descrittiva dell'entity Sconto
 */
public class ScontoModel implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    private String nomeSconto;
    private int percentuale;
    private Date dataInizio;
    private Date dataFine;
    private String tipo;
    private Integer quantita;
    private int idAzienda;

    private List<ProdottoModel> prodotti;


    public ScontoModel() {}

    public ScontoModel(int id, String nomeSconto, int percentuale, 
            Date dataInizio, Date dataFine, String tipo, Integer quantita, 
            int idAzienda, List<ProdottoModel> prodotti) {
        this.id = id;
        this.nomeSconto = nomeSconto;
        this.percentuale = percentuale;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.tipo = tipo;
        this.quantita = quantita;
        this.idAzienda = idAzienda;
        this.prodotti = prodotti;
    }
    
    public ScontoModel(Sconto s) {
        this.id = s.getId();
        this.nomeSconto = s.getNomeSconto();
        this.percentuale = s.getPercentuale();
        this.dataInizio = s.getDataInizio();
        this.dataFine = s.getDataFine();
        this.tipo = s.getTipo();
        this.quantita = s.getQuantita();
        this.idAzienda = s.getIdAzienda();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    public int getIdAzienda() {
        return idAzienda;
    }

    public void setIdAzienda(int idAzienda) {
        this.idAzienda = idAzienda;
    }

    public List<ProdottoModel> getProdotti() {
        return prodotti;
    }

    public void setProdotti(List<ProdottoModel> prodotti) {
        this.prodotti = prodotti;
    }

    public String getNomeSconto() {
        return nomeSconto;
    }

    public void setNomeSconto(String nomeSconto) {
        this.nomeSconto = nomeSconto;
    }

   
}