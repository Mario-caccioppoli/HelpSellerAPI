
package unisa.is.helpseller.Entity;

import java.io.Serializable;

public class ScontoProdottoId implements Serializable {
    private int id_sconto;
    private int id_prodotto;
    
    public ScontoProdottoId(int id_sconto, int id_prodotto) {
        this.id_sconto = id_sconto;
        this.id_prodotto = id_prodotto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id_sconto;
        hash = 97 * hash + this.id_prodotto;
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
        final ScontoProdottoId other = (ScontoProdottoId) obj;
        if (this.id_sconto != other.id_sconto) {
            return false;
        }
        return this.id_prodotto == other.id_prodotto;
    }
    
    
}
