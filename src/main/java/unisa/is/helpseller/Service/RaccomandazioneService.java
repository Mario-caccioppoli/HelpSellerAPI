package unisa.is.helpseller.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import unisa.is.helpseller.Entity.Recensione;
import unisa.is.helpseller.Model.ProdottoModel;

/**
 *
 * classe implementativa dei servizi riguardati il Raccomandation Engine
 */

@Service
@Transactional
public class RaccomandazioneService {

    /**
     * metodo per la generazione di un file .csv contenente le recensioni presenti nel db
     * @throws IOException caso in cui non viene trovato il file .exe
     */
    public void creaCsv() throws IOException{
        Runtime runTime = Runtime.getRuntime();
            
        String eseguibilePath = "getReviews.exe";
        runTime.exec(eseguibilePath);
    }

    /**
     * metodo per il recupero dei prodotti più popolari sulla piattaforma
     * @param ps oggetto ProdottoService
     * @return vettore di oggetti prodottoModel
     * @throws IOException caso in cui non viene trovato il file .exe
     */

    public ProdottoModel[] firstLayer(ProdottoService ps) throws IOException {
        ProdottoModel[] array = new ProdottoModel[10];   //da modificare la dimensione dell'array

        Runtime runTime = Runtime.getRuntime();
        String eseguibilePath = "firstLayer.exe";
        Process process = runTime.exec(eseguibilePath);

        //lettura parametri passati da firstLayer.exe
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;
        int i = 0;
        while ((line = br.readLine()) != null && i < 10) { //cambiare qua quando rendo la dimensione dell'array dinamico
            array[i] = new ProdottoModel(ps.findId(Integer.valueOf(line)));
            i++;
        }
        return array;
    }

    /**
     * //Funzionamento: il parametro ID preso dal frontned indica l'utente che sta visualizzando la pagina
     * //Viene preso l'ultimo articolo recensito dall'utente
     * //Vengono trovati gli articoli simili e restituiti al frontend
     * @param ds oggetto RecensioneService
     * @param ps oggetto ProdottoService
     * @param id dell'utente che sta navigando sulla piattaforma
     * @return model contente i prodotti da suggerire
     * @throws IOException caso in cui non viene trovato il file .exe
     */
    //ex input: 2, distributoreID 2 ha recensito l'ultima volta idProdotto 3. Modulo FIA riconosce che idProdotto 3 è correlato ai prodotti 1, 2, 11.
    public ProdottoModel[] secondLayer(RecensioneService ds, ProdottoService ps, int id) throws IOException {
        System.out.println("stampa PER RIDERE");
        String eseguibilePath = "secondLayer.exe";
        int prodConsiderati = 10;   // il suggerimento viene basato sugli ultimi 10 articoli interagiti
        int prodSuggeriti = 10;     //n prodotti restituiti al frontend
        ProdottoModel[] array = new ProdottoModel[prodSuggeriti];
        ProdottoModel prodottoM;   
        Recensione r = new Recensione();
        List<String> campioni = new ArrayList<>();
        campioni.add(eseguibilePath);
        
        List<Recensione> l = ds.findAll();
        Iterator<Recensione> it = l.iterator();
        int i = 0;
        while(it.hasNext() && i < prodConsiderati){
            r = it.next();
            if(id == r.getIdDistributore()){
                campioni.add(String.valueOf(r.getIdProdotto() -1));  //c'è un problema, affinché i dati siano coerenti su python occorre che vi sia una recensione per ogni prodotto!
                i++;
            }
        }
        //Process process = new ProcessBuilder(eseguibilePath, String.valueOf(campione)).start();
        Process process = new ProcessBuilder(campioni).start();
        
        //lettura parametri passati da secondLayer.exe
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;
        int j = 0;
        while ((line = br.readLine()) != null && j<prodSuggeriti) {
            System.out.println(line);
            array[j] = prodottoM = new ProdottoModel(ps.findId(Integer.valueOf(line)));
            j++;
        }
        return array;
    }
     
    
    /* VERSIONE VECCHIA MA STABILE
    public ProdottoModel[] firstLayer(ProdottoService ps) throws IOException{
        ProdottoModel[] array = new ProdottoModel[9];   //da modificare la dimensione dell'array
        ProdottoModel prodottoM;
        
        Runtime runTime = Runtime.getRuntime();
        String eseguibilePath = "firstLayer.exe";
        Process process = runTime.exec(eseguibilePath);
        
        //lettura file txt generato da firstLayer.exe
        
         try {
            File myObj = new File("firstLayer.txt");
            Scanner myReader = new Scanner(myObj);
            
            //skippo le prime due righe a causa del formato del file
            myReader.nextLine();
            myReader.nextLine();
            
            int i = 0;
            while (myReader.hasNextLine()) {
                int id = myReader.nextInt();
                
                array[i] = prodottoM = new ProdottoModel(ps.findId(id));
                
                myReader.nextLine();
                i++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        return array;
    }
    */
}