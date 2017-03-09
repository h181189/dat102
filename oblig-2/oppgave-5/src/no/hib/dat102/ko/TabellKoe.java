package no.hib.dat102.ko;

 public class TabellKoe<T> implements KoeADT<T>{
   private final int STDK  = 100;
   private int bak;
   private T[] koe; 

   /**
    * Oppretter en ny ko med standard størrelse.
    */
   public TabellKoe() {
     bak = 0;
     koe = (T[])(new Object[STDK]);
     
   }

   /**
    * Oppretter ny ko med spesifisert storrelse.
    * 
    * @param startKapasitet
    */
   public TabellKoe (int startKapasitet)   {
      bak = 0;     
      koe = (T[])(new Object[startKapasitet]);
    }

   /**
    * Legger et gitt element til bakerst i koen, og utvider dersom det er nodvendig.
    */
   public void innKoe(T element){
      if (antall() == koe.length) 
         utvid();

      koe[bak] = element;
      bak++;
   }

   /**
    * Fjerner elementet foran i koen.
    * 
    * @return fjernet element
    */
   public T utKoe() {
    
       T resultat = null;
        if (!erTom()){              
           resultat = koe[0];
           bak--;
         }

      /** flytter elementene en plass frem */
      for (int soek=0; soek < bak; soek++){
           koe[soek] = koe[soek+1];
		}
      koe[bak] = null;  // kan sl�yfes
      return resultat;
   }
  
  /**
   * Returnerer forste element.
   */
   public T foerste() {
    
       T resultat = null;
  
      if (!erTom()){
          resultat = koe[0];
      }
      return resultat;
   }

   /**
    * 
    * @return om koen er tom
    */
   public boolean erTom(){
      return (bak == 0);
   }
 
   /**
    * Returnerer antall elementer i koen.
    */
   public int antall()  {
      return bak;
   }

   /**
    * Returnerer en strengrepresentasjon av koen.
    */
   public String toString() {
      String resultat = "";

      for (int sok=0; sok < bak; sok++){ 
         resultat = resultat + koe[sok].toString() + "\n";
      }
      return resultat;
   }

   /**
    * Oppretter en ny tabell storre for a legge til elementer.
    */
   private void utvid() {
      T[] hjelpetabell = (T[])(new Object[koe.length*2]);

      for (int sok =0; sok < koe.length; sok++){
          hjelpetabell[sok] = koe[sok];
       }
       koe = hjelpetabell;
   }

}



