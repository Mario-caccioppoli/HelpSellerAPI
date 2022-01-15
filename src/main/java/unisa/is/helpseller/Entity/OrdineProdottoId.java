package unisa.is.helpseller.Entity;

import java.io.Serializable;

public class OrdineProdottoId implements Serializable {
    private int id_ordine;
    private int id_prodotto;
    
    public OrdineProdottoId() {}
    
    public OrdineProdottoId(int id_ordine, int id_prodotto) {
        this.id_ordine = id_ordine;
        this.id_prodotto = id_prodotto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id_ordine;
        hash = 59 * hash + this.id_prodotto;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrdineProdottoId other = (OrdineProdottoId) obj;
        if (this.id_ordine != other.id_ordine) {
            return false;
        }
        return this.id_prodotto == other.id_prodotto;
    }

    public int getId_ordine() {
        return id_ordine;
    }

    public void setId_ordine(int id_ordine) {
        this.id_ordine = id_ordine;
    }

    public int getId_prodotto() {
        return id_prodotto;
    }

    public void setId_prodotto(int id_prodotto) {
        this.id_prodotto = id_prodotto;
    }
    
    
}
