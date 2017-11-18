/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sicurezza_progetto_3;
import java.security.*;
import javax.crypto.*;
import java.util.*;


/**
 * Il compito di questa classe è generare le richieste di Timestamp da inoltrare
 * al server TSA, ricevere i messaggi corrispondenti e verificarne la validità.
 * Viene generato l'hash associato al messaggio dell'utente i, si allega il suo ID,
 * viene firmato il tutto e poi cifrato.
 * Il server TSA genera il timestamp, lo firma e cifra la risposta. Una volta ricevuta viene valutata
 * la validità della firma apposta dal TSA, vengono usate le informazioni contenute
 * nel timestamp per controllare HV e SHV con il proprio hash, e infine viene firmato
 * il timestamp stesso, in maniera tale da proteggersi nel caso di scadenza di esso.
 * 
 * Supponiamo che in ogni timeframe inviamo al server una Map di richieste che deve gestire
 * tutte. Ogni elemento della Map è una stringa cifrata di un JSONObject contenente:
 * 1)IDUtente
 * 2)Hash del messaggio
 * 2)Algoritmo di firma
 * 3)Firma 
 * Lui ci risponde con una Map di risposte di cui dobbiamo verificare la validità.
 */

public class TimestampManager {
    
    private String hashAlgorithm; //Tipo di algoritmo hash che il server TSA deve usare.
    private int requestsNumber; //Numero di richieste nel Time Frame i
    private int IDNumber; //Inizializzato a 0, lo incrementiamo per ogni utente che fa le richieste
    private TSA TSAServer; //TSA Server
    private HashMap<String,TSARequest> requests;
    
    public TimestampManager(String hashAlgorithm, TSA TSAServer){
        this.hashAlgorithm = hashAlgorithm;
        this.TSAServer = TSAServer;
        this.requestsNumber = 0;
        this.IDNumber = 0;
        this.requests = null;
    }
    
    public void newTimeframe(int requestsNumber){
        this.requestsNumber = requestsNumber;
        this.requests = new HashMap<>();
    }
    
    /*Il metodo riceve un oggetto utente e il messaggio a cui vuole apporre la 
    marca temporale. Il metodo genera l'hash di message e salva lui e l'ID dell'utente
    in un JSONObject da passare al costruttore di TSARequest. In TSARequest il JSONObject
    viene convertito in stringa, firmato e cifrato.
    Viene poi inserito nella Map con una certa chiave e il valore la TSARequest.
    */
    public void generateRequest(User user, byte[] message){
        //provaeisa
    }
    
    /*
    Passa la Map di richieste al server TSA e riceve la Map di risposte.
    Decifra la stringa di ogni elemento della Map di risposta ricevuta con la propria
    chiave privata RSA, controlla la validità della firma (con la chiave pubblica
    DSA del server TSA), e usa i dati al suo interno per controllare la validità
    della marca temporale apposta. Lancia un'eccezione per l utente i-esimo se 
    la sua marca non è verificata*/ 
    public void verifyResponses(){
 
    }
}
