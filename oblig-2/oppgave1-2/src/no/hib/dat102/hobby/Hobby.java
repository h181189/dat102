package no.hib.dat102.hobby;

public class Hobby {
	
	private String hobbyNavn;

	public Hobby(String hobby) {
		hobbyNavn = hobby;
	}

	public String toString() {
		return '<' + hobbyNavn + '>';
	}
	
	public void setHobbyNavn(String navn) {
		this.hobbyNavn = navn;
	}

	public String getHobbyNavn() {
		return hobbyNavn;
	}
	
	public boolean equals(Object hobby2) {
		Hobby hobbyDenAndre = (Hobby) hobby2;
		return (hobbyNavn.equals(hobbyDenAndre.getHobbyNavn()));
	}
}