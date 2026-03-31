package ovPasSysteem;

public class ovPasSysteemDriver
{
    public static void main(String[] args)
    {
	ovPasSysteemPas pasA = new ovPasSysteemPas(2030, 10.00, false); // (geldigTotDatum, saldo, statusIncheck) //
	ovPasSysteemPoortOfPaal poortA = new ovPasSysteemPoortOfPaal("Elst", false, 2026); // (locatie , poort, huidigJaar) //
	ovPasSysteemPoortOfPaal poortB = new ovPasSysteemPoortOfPaal("Nijmegen-Lent", true, 2026); // (locatie , poort, huidigJaar) //

	// Inchecken
	poortA.validiteitCheck(pasA); // Check of pas gelding is. (inchecken)
	poortA.saldoCheck(pasA);      // Check of dat er meer dan €10.00 op de pas is in saldo. (inchecken)
	poortA.inChecken(pasA);       // Laat de pas inchecken. (inchecken)
	
	                              // We checken niet meer voor validiteid en saldo bij uitchecken. 
	                              // Want validiteid is al bij inchecken gedaan en verandered niet tijdes de reis.
	                              // En je saldo kan negatief raken tijdens de reis en dit wordt bij het opnieuw inchecken geadreseerd.
	// Uitchecken	
	poortB.berekenBetaling(pasA); // Hier berekenen we hoeveel je betaalt op basis van hoevaak je locatie is overschreven. (uitchecken)
	poortB.uitChecken(pasA);      // Laat de pas uitchecken. (uitchecken)


    }

}
