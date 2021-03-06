package unisa.is.helpseller.Model;


import java.sql.Date;
import java.io.Serializable;
import java.util.List;
import unisa.is.helpseller.Entity.Ordine;

/**
 * Classe model utilizzata per la comunicazione col frontend descrittiva dell'entity Ordine
 */
public class OrdineModel implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    private Date dataOrdinazione;
    private Date dataConsegna;
    private String commento;
    private String stato;
    private int idDistributore;
    private String nomeDistributore;
    private DocumentoModel documento;
    private double prezzoTotale;
    private List<OrdineProdottoModel> ordineProdotti;
    private AziendaModel azienda;
 
    public OrdineModel() {}

    public OrdineModel(Date dataOrdinazione, Date dataConsegna, String commento, 
            String stato, int idDistributore, String nomeDistributore, DocumentoModel documento, 
            double prezzoTotale, List<OrdineProdottoModel> ordineProdotti, AziendaModel azienda) {
        this.dataOrdinazione = dataOrdinazione;
        this.dataConsegna = dataConsegna;
        this.commento = commento;
        this.stato = stato;
        this.idDistributore = idDistributore;
        this.nomeDistributore = nomeDistributore;
        this.documento = documento;
        this.prezzoTotale = prezzoTotale;
        this.ordineProdotti = ordineProdotti;
        this.azienda = azienda;
    }
    
    public OrdineModel(Ordine o) {
        this.id = o.getId();
        this.dataOrdinazione = o.getDataOrdinazione();
        this.dataConsegna = o.getDataConsegna();
        this.commento = o.getCommento();
        this.stato = o.getStato();
        this.idDistributore = o.getIdDistributore();
        this.nomeDistributore = null;
        this.documento = null;
        this.ordineProdotti = null;
        this.azienda = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataOrdinazione() {
        return dataOrdinazione;
    }

    public void setDataOrdinazione(Date dataOrdinazione) {
        this.dataOrdinazione = dataOrdinazione;
    }

    public Date getDataConsegna() {
        return dataConsegna;
    }

    public void setDataConsegna(Date dataConsegna) {
        this.dataConsegna = dataConsegna;
    }

    public String getCommento() {
        return commento;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public int getIdDistributore() {
        return idDistributore;
    }

    public void setIdDistributore(int idDistributore) {
        this.idDistributore = idDistributore;
    }

    public DocumentoModel getDocumento() {
        return documento;
    }

    public void setDocumento(DocumentoModel documento) {
        this.documento = documento;
    }

    public double getPrezzoTotale() {
        return prezzoTotale;
    }

    public void setPrezzoTotale(double prezzoTotale) {
        this.prezzoTotale = prezzoTotale;
    }

    public List<OrdineProdottoModel> getOrdineProdotti() {
        return ordineProdotti;
    }

    public void setOrdineProdotti(List<OrdineProdottoModel> ordineProdotti) {
        this.ordineProdotti = ordineProdotti;
    }

    public AziendaModel getAzienda() {
        return azienda;
    }

    public void setAzienda(AziendaModel azienda) {
        this.azienda = azienda;
    }

    public String getNomeDistributore() {
        return nomeDistributore;
    }

    public void setNomeDistributore(String nomeDistributore) {
        this.nomeDistributore = nomeDistributore;
    }
    

    
}