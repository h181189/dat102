package no.hib.dat102;

public class KlientBalansering {
	public static void main(String[] args) {
		final String filnavn = "resource/data.txt";
	
		// Leser inn en tekst fra fil
		Balansering balansering = new Balansering();
		balansering.lesFraFil(filnavn);
	}

}
