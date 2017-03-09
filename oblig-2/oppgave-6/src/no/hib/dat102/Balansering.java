package no.hib.dat102;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Balansering {
	TabellStabel<Parentesinfo> stabel = new TabellStabel<Parentesinfo>();

	private boolean passer(char aapent, char lukket) {
		switch (aapent) {
		case '(':
			return (lukket == ')');
		case '[':
			return (lukket == ']');
		case '{':
			return (lukket == '}');
		default:
			return false;
		}
	}//

	public void foretaBalansering(String innDataStreng, int linjenr) {
		final int lengde = innDataStreng.length();
		boolean balanced = true;
		Parentesinfo pi = new Parentesinfo();

		for (int i = 0; i < lengde && balanced; i++) {
			char letter = innDataStreng.charAt(i);

			if (letter == '{' || letter == '[' || letter == '(') {
				pi.setLinjenr(linjenr);
				pi.setPosisjon(i);
				pi.setVenstreparentes(letter);
				stabel.push(pi);
			} else if (letter == '}' || letter == ']' || letter == ')') {
				if (stabel.isEmpty()) {
					balanced = false;
					String error = "Lukkesymbol " + letter + " på linje " + linjenr + ", tegn nr " + i
							+ " mangler tilsvarende åpnesymbol";
					System.out.println(error);
				} else {
					Parentesinfo top = stabel.pop();
					char previous = top.getVenstreparentes();
					balanced = passer(previous, letter);

					if (!balanced) {
						String error = "Lukkesymbol " + letter + " på linje nr " + linjenr + ", tegn nr " + i
								+ " har feil apnesymbol";
						System.out.println(error);
						balanced = true;
					}
				}
			}
		}
		while (!stabel.isEmpty()) {
			pi = stabel.pop();
			char parantes = innDataStreng.charAt(pi.getPosisjon());
			String error = "Apnesymbol " + parantes + " " + " pa linje " + pi.getLinjenr() + ", tegn nr "
					+ pi.getPosisjon() + " har ikke tilsvarende lukkesymbol";
			System.out.println(error);
		}

	}

	public void lesFraFil(String filnavn) {
		FileReader tekstFilLeser = null;
		try {
			tekstFilLeser = new FileReader(filnavn);
		} catch (FileNotFoundException unntak) {
			System.out.println("Finner ikke filen!");
			System.exit(-1);
		}

		BufferedReader tekstLeser = new BufferedReader(tekstFilLeser);
		String linje = null;
		int linjenr = 0;
		try {
			while ((linje = tekstLeser.readLine()) != null) {
				foretaBalansering(linje, ++linjenr);
			}
		}

		catch (IOException unntak) {
			System.out.println("Feil ved innlesing!");
			System.exit(-1);
		}
		try {
			tekstFilLeser.close();
		} catch (IOException unntak) {
			System.out.println("Feil ved lukking av fil!");
		}

	}

}
