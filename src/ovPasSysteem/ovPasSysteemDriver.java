package ovPasSysteem;

import java.util.Arrays;
import java.util.Scanner;

public class ovPasSysteemDriver
{
  static String[] yesOrNoOptions = { "y", "n" };
    
    public static String vraag(String vraag) {
	    Scanner sc = new Scanner(System.in);
	    System.out.println(vraag);
	    String antwoordVraag = sc.nextLine().toLowerCase();
	    return antwoordVraag;
	}
    
    
    public static void main(String[] args)
    {
	
	ovPasSysteemReiziger reizigerA = new ovPasSysteemReiziger(20.00); // (bankRekening)
	ovPasSysteemPas pasA = new ovPasSysteemPas(3528, 2030, 10.00, false); // (pasNr, geldigTotDatum, saldo, statusIncheck)							      
	ovPasSysteemOplaadAutomaat automaatA = new ovPasSysteemOplaadAutomaat(10.00);
	ovPasSysteemPoortOfPaal poortA = new ovPasSysteemPoortOfPaal("Elst", false, 2026); // (locatie , poort, huidigJaar)
	ovPasSysteemPoortOfPaal poortB = new ovPasSysteemPoortOfPaal("Nijmegen-Lent", true, 2026); // (locatie , poort, huidigJaar)

	
	
	// Inchecken
	poortA.validiteitCheck(pasA); // Check of pas geldig is. (inchecken)
	if (pasA.getSaldo() < 10.00)  // Check of dat er meer dan €10.00 op de pas is in saldo. (inchecken)
	{
	    System.out.println("Uw saldo is te laag zet meer saldo op je ov-pas om weer te kunnen reizen.");
	    while (automaatA.getProccesAutomaatKlaar() == false ) {
		String antwoordTemp = vraag("de vraag dei gestelt wordt");
		    if (Arrays.asList(yesOrNoOptions[0]).contains(antwoordTemp)) {
			automaatA.bankAftrekken(reizigerA);
			automaatA.opwaderen(pasA);
		    }
		    
	    }
	    
	} else
	{
	    poortA.setProccesKlaar(true);
	}
	poortA.inChecken(pasA); // Laat de pas inchecken. (inchecken)

	// We checken niet meer voor validiteid en saldo bij uitchecken.
	// Want validiteid is al bij inchecken gedaan en verandered niet tijdes de reis.
	// En je saldo kan negatief raken tijdens de reis en dit wordt bij het opnieuw
	// inchecken geadreseerd.
	
	// Uitchecken
	poortB.berekenBetaling(pasA); // Hier berekenen we hoeveel je betaalt op basis van hoevaak je locatie is overschreven. (uitchecken)
	poortB.uitChecken(pasA); // Laat de pas uitchecken. (uitchecken)

    }

}
