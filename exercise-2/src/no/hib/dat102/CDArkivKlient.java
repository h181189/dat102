package no.hib.dat102;

import no.hib.dat102.adt.CDarkivADT;

public class CDArkivKlient {
	public static void main(String[] args){
		 CDarkivADT cda = new CDarkiv(20);
		 Meny meny = new Meny(cda);
		 meny.start();
	}
}