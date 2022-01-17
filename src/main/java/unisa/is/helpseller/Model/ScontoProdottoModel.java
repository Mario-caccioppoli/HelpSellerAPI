package unisa.is.helpseller.Model;


import java.io.Serializable;

public class ScontoProdottoModel implements Serializable {
    private ProdottoModel prodotto;
    private ScontoModel sconto;

    public ScontoProdottoModel() {}

    public ScontoProdottoModel(ProdottoModel prodotto, ScontoModel sconto) {
        this.prodotto = prodotto;
        this.sconto = sconto;
    }

    public ProdottoModel getProdotto() {
        return prodotto;
    }

    public void setProdotto(ProdottoModel prodotto) {
        this.prodotto = prodotto;
    }

    public ScontoModel getSconto() {
        return sconto;
    }

    public void setSconto(ScontoModel sconto) {
        this.sconto = sconto;
    }

    
}