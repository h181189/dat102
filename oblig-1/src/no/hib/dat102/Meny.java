package no.hib.dat102;

import java.util.Scanner;

import no.hib.dat102.adt.CDarkivADT;

public class Meny {
	
	private Tekstgrensesnitt tekstgr;
	private CDarkivADT cda;
	
	private final String FILNAVN = "resources/cdarkiv.txt";

	public Meny(CDarkivADT cda) {
		tekstgr = new Tekstgrensesnitt();
		this.cda = cda;
	}

	public void start() {
		Scanner input = new Scanner(System.in);

		boolean ferdig = false;
		Fil fil = new Fil();
		int svar;
		
		while (!ferdig) {
			System.out.println("Hva vil du gjøre? (0)Eksporter fil til arkiv (1)Se arkiv (2)Les fil (3)Skriv til fil (4)Legg til CD (5)Slett CD (6)Søk etter artist (7)Søk etter tittel (8)Søk sjanger (9)Ferdig");
			svar = input.nextInt();

			switch (svar) {
			case 0:
				for (CD cd : fil.lesFraFil(FILNAVN).hentCdTabell()) {
					cda.leggTilCd(cd);
				}
				break;
			case 1:
				if (cda.hentAntall() > 0) {
					for (CD cd : cda.hentCdTabell()) {
						tekstgr.visCD(cd);
						System.out.println();
					}
				}
				break;

			case 2:
				for (CD cd : fil.lesFraFil(FILNAVN).hentCdTabell()) {
					tekstgr.visCD(cd);
					System.out.println();
				}
				break;

			case 3:
				System.out.println("Hvis du vil utvide fil skriv: 'true'. Vil du overskrive skriv: 'false'");
				boolean b = input.nextBoolean();
				
				fil.skrivTilFil(cda, FILNAVN, b);
				break;
				
			case 4:
				cda.leggTilCd(tekstgr.lesCD());
				break;
				
			case 5:
				System.out.println("Hvilke CD-nummer vil du slette?");
				int cdNr = input.nextInt();
			
				cda.slettCd(cdNr);
				break;
				
			case 6:
				System.out.println("Hvilke artist vil du søke etter?");
				input.nextLine();
				String artist = input.nextLine(); 
						
				tekstgr.skrivUtCdArtist(cda, artist);
				break;
				
			case 7:
				System.out.println("Hvilke tittel vil du søke etter?");
				input.nextLine();
				String tittel = input.nextLine(); 
				
				tekstgr.skrivUtCdDelstrengITittel(cda, tittel);
				break;
				
			case 8:
				System.out.println("Hvilke sjanger vil du søke etter?");
				input.nextLine();
				Sjanger sjanger = Sjanger.valueOf(input.nextLine().toUpperCase()); 
				
				CD[] sjangre = cda.hentCdTabell();
				for(CD cd : sjangre) {
					if(cd.getSjanger() == sjanger){
						tekstgr.visCD(cd);
					}
				}
				
				break;
				
			case 9:
				ferdig = true;
				break;
				
			default:
				System.out.println("Vennligst svar med et tall mellom 1 og 9");
				break;
			}
		}
	}
}
