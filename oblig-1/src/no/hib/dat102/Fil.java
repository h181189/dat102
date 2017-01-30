package no.hib.dat102;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import no.hib.dat102.adt.CDarkivADT;

/**
 * @author Ole Olsen
 * 
 */
public class Fil {

	private static String SKILLE = "#";

	/**
	 * @param filnavn
	 * @return Referansen til CD-arkivet
	 * @throws java.io.IOException
	 */
	public CDarkivADT lesFraFil(String filnavn) {

		CDarkivADT cda = null;

		try {
			// 1 - FileReader
			FileReader ansFil = new FileReader(filnavn);

			// 2 - BufferedReader
			BufferedReader innfil = new BufferedReader(ansFil);
			
			// 3 - Leser den første posten som er antall info-poster
			String linje = innfil.readLine();
			int n;
			try {
				n = Integer.parseInt(linje);
			} catch (NumberFormatException e) {
				n = 0;
			}
			
			// Oppretter CDarkiv
			cda = new CDarkiv(n == 0 ? 1 : n);
			
			// 4 - Les postene, en hel post om gangen
			for (int i = 0; i < n; i++) {
				String post = innfil.readLine();
				String[] felt = post.split(SKILLE);
				int nr = Integer.parseInt(felt[0]);
				String artist = felt[1];
				String tittel = felt[2];
				int aar = Integer.parseInt(felt[3]);
				Sjanger sjanger = Sjanger.valueOf(felt[4].toUpperCase()); // Eventuelt lagret
															// som heltall
				String plateselskap = felt[5];

				CD cd = new CD(nr, artist, tittel, aar, sjanger, plateselskap);

				cda.leggTilCd(cd);
			}

			// 4 - Lukk filen
			innfil.close();

		} catch (FileNotFoundException unntak) {// arver fra IOException må stå
												// først
												// hvis ikke vil unntaket for
												// IOException skygge
			System.out.println("Finner ikke filen " + filnavn);
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Feil ved lesing av fil: " + e);
			System.exit(2);
		}

		return cda;
	}

	public void skrivTilFil(CDarkivADT cdarkiv, String filnavn, boolean utvid) {
		try {
			String innhold;
			
			if (utvid) {
				CDarkivADT gammelt = lesFraFil(filnavn);
				innhold = Integer.toString(gammelt.hentAntall() + cdarkiv.hentAntall()) + '\n';
				for (CD cd : gammelt.hentCdTabell()) {
					innhold += cd.toString() + '\n';
				}
			} else {
				innhold = Integer.toString(cdarkiv.hentAntall()) + '\n';
			}
			for (CD cd : cdarkiv.hentCdTabell()) {
				innhold += cd.toString() + '\n';
			}
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(filnavn));
			writer.write(innhold);
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Kan ikke finne filen " + filnavn);
		} catch (IOException e) {
			System.out.println("Kan ikke skrive til filen");
		}

	}

}// class
