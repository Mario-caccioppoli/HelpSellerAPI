package unisa.is.helpseller.Model;


import java.io.Serializable;
import unisa.is.helpseller.Entity.Prodotto;
import unisa.is.helpseller.Entity.Sconto;

public class ScontoProdottoModel implements Serializable {
    private Prodotto prodotto;
    private Sconto sconto;

    public ScontoProdottoModel() {}

    public ScontoProdottoModel(Prodotto prodotto, Sconto sconto) {
        this.prodotto = prodotto;
        this.sconto = sconto;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public Sconto getSconto() {
        return sconto;
    }

    public void setSconto(Sconto sconto) {
        this.sconto = sconto;
    }
    
}