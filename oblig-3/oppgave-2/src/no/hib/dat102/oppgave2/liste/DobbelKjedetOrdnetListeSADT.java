package no.hib.dat102.oppgave2.liste;

public interface DobbelKjedetOrdnetListeSADT<T> {
 
 /**
  * 
  * @param el er elementet som skal legges til
  */
  void leggTil(T el);
  
  
  /**
   * 
   * @param el er elementet det s�kes etter
   * @return true hvis elementet fins ellers false
   */    
  boolean fins(T el);
  
  /**
   * 
   * @param el er elementet som skal fjernes hvis det fins
   * @return elementet som skal fjernes ellers returneres null
   */  
  T fjern(T el);
  

}
