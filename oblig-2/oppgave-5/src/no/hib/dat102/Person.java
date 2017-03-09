package no.hib.dat102;

public class Person implements Comparable<Person> {

	private String fodselsar;
	private String fornavn;
	private String etternavn;
	
	public Person(String fodselsar, String fornavn, String etternavn) {
		this.fodselsar = fodselsar;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
	}
	
	public String getFodselsar() {
		return fodselsar;
	}
	
	public String getFornavn() {
		return fornavn;
	}
	
	public String getEtternavn() {
		return etternavn;
	}
	
	public void setFodselsar(String fodselsar) {
		this.fodselsar = fodselsar;
	}
	
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}
	
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}
	
	@Override
	public String toString() {
		return fodselsar + " " + etternavn + " " + fornavn;
	}
	
	@Override
	public int compareTo(Person o) {
		return toString().compareTo(o.toString());
	}
	
}
