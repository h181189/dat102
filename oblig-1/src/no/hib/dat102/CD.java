package no.hib.dat102;

public class CD {
	
	private int nummer;
	private String artist;
	private String tittel;
	private int dato;
	private Sjanger sjanger;
	private String plateselskap;
	
	public CD(int nummer, String artist, String tittel, int dato, Sjanger sjanger, String plateselskap) {
		this.nummer = nummer;
		this.artist = artist;
		this.tittel = tittel;
		this.dato = dato;
		this.sjanger = sjanger;
		this.plateselskap = plateselskap;
	}

	public CD() {
		this(0, "", "", 0, null, "");
	}

	public int getNummer() {
		return nummer;
	}

	public String getArtist() {
		return artist;
	}

	public String getTittel() {
		return tittel;
	}

	public int getDato() {
		return dato;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public String getPlateselskap() {
		return plateselskap;
	}
	
	@Override
	public String toString() {
		return nummer + "#" + artist + "#" + tittel + "#" + dato + "#" + sjanger + "#" + plateselskap; 
	}
	
}
