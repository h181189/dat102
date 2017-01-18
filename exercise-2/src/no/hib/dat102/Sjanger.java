package no.hib.dat102;

public enum Sjanger {
	ROCK(0), POP(1), OPERA(2), CLASSIC(3), INDIE(4), COUNTRY(5);

	private int nr;

	private Sjanger(int n) {
		nr = n;
	}

	public int getNr() {
		return nr;
	}

	public static Sjanger finnSjanger(int n) {
		Sjanger sjang = null;
		for (Sjanger sj : Sjanger.values()) {
			if (sj.nr == n) {
				sjang = sj;
				break;
			}
		}
		return sjang;
	}

}
