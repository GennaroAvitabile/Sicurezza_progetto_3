/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sicurezza_progetto_3;

/**

 */
public class TSARequest {
    public String Info;
    public byte[] sign;
    public String signType;
    
    /*Riceve il JSONObject e l'oggetto user. Converte il JSON object in stringa, lo firma
    usando la chiave privata DSA dell'user e lo cifra usando la chiave RSA pubblica del server TSA.
    */
    public TSARequest(JSONObject j, User u){
        
    }
}
