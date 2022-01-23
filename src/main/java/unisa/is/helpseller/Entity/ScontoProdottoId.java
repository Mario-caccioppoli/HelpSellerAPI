
package unisa.is.helpseller.Entity;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Classe descrittiva dell'oggetto entity ScontoProdottoid
 */
public class ScontoProdottoId implements Serializable {
    private Integer id_sconto;
    private Integer id_prodotto;
    
    @Autowired
    public ScontoProdottoId() {
    	
    }
    public ScontoProdottoId(Integer id_sconto, Integer id_prodotto) {
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

    public int getIdSconto() {
        return id_sconto;
    }

    public void setIdSconto(Integer id_sconto) {
        this.id_sconto = id_sconto;
    }

    public int getIdProdotto() {
        return id_prodotto;
    }

    public void setIdProdotto(Integer id_prodotto) {
        this.id_prodotto = id_prodotto;
    }
    
    
}
