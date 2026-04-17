package ovPasSysteem;

import java.util.Arrays;
import java.util.Scanner;

public class ovPasSysteemDriver
{
    static Scanner sc = new Scanner(System.in);

    static String[] yesOrNoOptions =
    { "y", "n" };

    static String[] opwaardeerOpties =
    { "10", "20", "40" };

    public static String vraag(String vraag)
    {
	System.out.println(vraag);
	return sc.nextLine().toLowerCase();
    }

    public static void main(String[] args)
    {

	ovPasSysteemReiziger reizigerA = new ovPasSysteemReiziger(40.00); // (bankRekening)
	ovPasSysteemPas pasA = new ovPasSysteemPas(2030, 10.00, false); // (geldigTotDatum, saldo, statusIncheck)
	ovPasSysteemOplaadAutomaat automaatA = new ovPasSysteemOplaadAutomaat();
	ovPasSysteemPoortOfPaal poortA = new ovPasSysteemPoortOfPaal("Elst", false, 2026); // (locatie , poort, huidigJaar)
	ovPasSysteemPoortOfPaal poortB = new ovPasSysteemPoortOfPaal("Nijmegen-Lent", true, 2026); // (locatie , poort, huidigJaar)

	// Inchecken
	poortA.validiteitCheck(pasA); // Check of pas geldig is. (inchecken)
	if (pasA.getSaldo() < 10.00) // Check of dat er meer dan €10.00 op de pas is in saldo. (inchecken)
	{
	    System.out.println("Uw saldo is te laag zet meer saldo op je ov-pas om weer te kunnen reizen.");
	    while (automaatA.getProccesAutomaatKlaar() == false)
	    {
	// Oplaad automaat
		String antwoordAutomaat = vraag("wilt u geld op uw ov pas zetten? (y/n)");
		if (Arrays.asList(yesOrNoOptions[0]).contains(antwoordAutomaat))
		{
		    while (automaatA.getVraagAutomaatKlaar() == false)
		    {
			String antwoordOpwaarderen = vraag("Hoeveel geld wilt u op uw ov pas zetten? (10, 20, 40)");
			if (Arrays.asList(opwaardeerOpties[0]).contains(antwoordOpwaarderen)) // checkt of een geldig antwoord werd gegeven.
			{
			    automaatA.setUserInput(10.00);// zet het bedrag wat van de bankrekening wordt afgetrokken.
			    automaatA.setVraagAutomaatKlaar(true);// zorgt ervoor dat de while-loop de vargen die bij de oplaad automaat horen stopt.
			}

			else if (Arrays.asList(opwaardeerOpties[1]).contains(antwoordOpwaarderen)) // checkt of een geldig antwoord werd gegeven.
			{
			    automaatA.setUserInput(20.00);// zet het bedrag wat van de bankrekening wordt afgetrokken.
			    automaatA.setVraagAutomaatKlaar(true);// zorgt ervoor dat de while-loop de vargen die bij de oplaad automaat horen stopt.
			}

			else if (Arrays.asList(opwaardeerOpties[2]).contains(antwoordOpwaarderen)) // checkt of een geldig antwoord werd gegeven.
			{
			    automaatA.setUserInput(40.00);// zet het bedrag wat van de bankrekening wordt afgetrokken.
			    automaatA.setVraagAutomaatKlaar(true);// zorgt ervoor dat de while-loop de vargen die bij de oplaad automaat horen stopt.
			}
		    }
		    automaatA.bankAftrekken(reizigerA); // haalt het geld van de bank rekening
		    automaatA.opwaarderen(pasA); // zet het geld op de pas

		    if (automaatA.getProccesAutomaatKlaar() == true)
		    {
			poortA.setProccesKlaar(true);
		    }
		}

		else if (Arrays.asList(yesOrNoOptions[1]).contains(antwoordAutomaat)) // checkt of een geldig antwoord werd gegeven.
		{
		    automaatA.setProccesAutomaatKlaar(true); // zorgt ervoor dat de while-loop van de oplaad automaat stopt
		}

	    }

	} else if (pasA.getSaldo() >= 10.00) // checkt of saldo van de pas gelijk of meer is dan €10
	{
	    poortA.setProccesKlaar(true); // zet het incheck procces op true omdat de reiziger nu mag inchecken. (Want alle checks zijn voltooid)
	}
	poortA.inChecken(pasA); // Laat de pas inchecken. (inchecken)

	// We checken niet meer voor validiteid en saldo bij uitchecken.
	// Want validiteid is al bij inchecken gedaan en verandered niet tijdes de reis.
	// En je saldo kan negatief raken tijdens de reis en dit wordt bij het opnieuw
	// inchecken geadreseerd.

	// Uitchecken
	poortB.berekenBetaling(pasA); // Hier berekenen we hoeveel je betaalt op basis van hoe vaak je locatie is overschreven. (uitchecken)
	poortB.uitChecken(pasA); // Laat de pas uitchecken. (uitchecken)

    }

}
