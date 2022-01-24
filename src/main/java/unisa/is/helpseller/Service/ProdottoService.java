
package unisa.is.helpseller.Service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisa.is.helpseller.Entity.Prodotto;
import unisa.is.helpseller.Repo.ProdottoRepo;

/**
 *  Classe contenente tutti i servizi relativi all'entity Prodotto
 *
 */
@Service
@Transactional
public class ProdottoService {
	@Autowired
    private final ProdottoRepo prodottoRepo;
    
    @Autowired
    public ProdottoService(ProdottoRepo prodottoRepo) {this.prodottoRepo = prodottoRepo;}

    /**
     * metodo per il recupero di tutti le istanze presenti nel DB
     * @return List<Amministratore> lista di oggetti entity
     */
    public List<Prodotto> findAll() {
        return prodottoRepo.findAll();
    }

    /**
     * metodo per il recupero di una istanza dal DB dato in input il suo ID
     * @param id    intero ID dell'entità ricercata
     * @return oggetto prelevato dal DB, se presente
     */
    public Prodotto findId(int id) {
        return prodottoRepo.findId(id);
    }

    /**
     * metodo per la rimozione di una istanza dato l'id
     * @param id    id dell'entità da rimuovere
     * @return int id dell'entità rimossa
     */
    public int deleteId(int id) {
    	return prodottoRepo.deleteId(id);
    }

    /**
     * metodo per l'inserimento di un'istanza nel DB
     * @param prod Prodotto oggetto entity da inserire nel DB
     * @return int id dell'entità aggiunta
     */
    public int insert(Prodotto prod) {
    	return prodottoRepo.saveAndFlush(prod).getId();
    }

    /**
     * metodo per l'update di una entità presente nel DB
     * @param prod Prodotto oggetto entity da modificare nel DB
     * @return int id dell'entity modificata
     */
    public int udpate(Prodotto prod) {
    	return prodottoRepo.update(prod.getNomeProdotto(), prod.getPrezzo(), prod.getDescrizione(), 
                prod.getQuantita(), prod.getImmagine(), prod.getPeso(), prod.getVolume(), prod.getIdAzienda(), prod.getQuantitaMinima(), prod.getId());
    }

    /**
     * metodo di ricerca dei prodotti data un'azienda
     * @param id_azienda id dell'azienda
     * @return lista di prodotti recuperati
     */
    public List<Prodotto> findProdottiByAzienda(int id_azienda) {
       return prodottoRepo.findProdottiByAzienda(id_azienda);
    }

    /**
     * metodo di ricerca prodotti dato il nome
     * @param nome nome del prodotto
     * @return lista di prodotti recuperati
     */
    public List<Prodotto> findProdottiByNome(String nome) {
        return prodottoRepo.findProdottiByNome(nome);
    }

    /**
     * meteodo di ricerca dato il nome e l'azienda
     * @param nome nome del prodotto
     * @param id_azienda id dell'azienda
     * @return lista di prodotti recuperati
     */
    public List<Prodotto> findProdottiByNomeInAzienda(String nome, int id_azienda) {
        return prodottoRepo.findProdottiByNomeInAzienda(nome, id_azienda);
    }

    /**
     * metodo di ricerca dato un ordine
     * @param id_ordine id dell'ordine
     * @return lista di prodotti recuperati
     */
    public List<Prodotto> findProdottiInOrdine(int id_ordine) {
        return prodottoRepo.findProdottiInOrdine(id_ordine);
    }

    /**
     * metodo di ricerca dato uno sconto
     * @param id_sconto id dello sconto
     * @return lista di prodotti recuperati
     */
    public List<Prodotto> findProdottiBySconto(int id_sconto) {
        return prodottoRepo.findProdottiBySconto(id_sconto);
    }

    /**
     * metodo di ricerca dato un prodotto e l'azienda
     * @param id_prodotto id del prodotto
     * @param id_azienda id dell'azienda
     * @return lista di prodotti recuperati
     */
    public List<Prodotto> findProdottiByIdInAzienda(int id_prodotto, int id_azienda) {
        return prodottoRepo.findProdottiByIdInAzienda(id_prodotto, id_azienda);
    }
    

}
