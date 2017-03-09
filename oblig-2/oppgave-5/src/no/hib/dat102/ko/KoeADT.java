package no.hib.dat102.ko;

public interface KoeADT<T> {

	public void innKoe(T element);

	public T utKoe();

	public T foerste();

	public boolean erTom();

	public int antall();

}//