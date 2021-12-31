package unisa.is.helpseller.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name = "prodotto")
public class Prodotto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column
    private int idProdotto;
    
    @Column
    private String nomeProdotto;
    
    @Column
    private double prezzo;
    
    @Column
    private String descrizione;
    
    @Column
    private int quantita;
    
    @Column
    private String immagine;
    
    @Column
    private int quantitaMinima;
    
    @Column
    private int peso;
    
    @Column
    private int volume;
    
    @Column
    private int idAzienda;
    
 
    public Prodotto() {}

    public Prodotto(String nomeProdotto, double prezzo, String descrizione, int quantita, String immagine, int quantitaMinima, int peso, int volume, int idAzienda) {
        this.nomeProdotto = nomeProdotto;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
        this.quantita = quantita;
        this.immagine = immagine;
        this.quantitaMinima = quantitaMinima;
        this.peso = peso;
        this.volume = volume;
        this.idAzienda = idAzienda;
    }
    
    
}