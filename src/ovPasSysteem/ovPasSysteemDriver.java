package ovPasSysteem;

public class ovPasSysteemDriver
{
    public static void main(String[] args)
    {
	ovPasSysteemPas pasA = new ovPasSysteemPas(2030, 20.00); // (geldigTotDatum, saldo) //
	ovPasSysteemPoortOfPaal poortA = new ovPasSysteemPoortOfPaal("Nijmegen", false, 2026); // (locatie =, poort, huidigJaar) //

	poortA.validiteitCheck(pasA);
	poortA.saldoCheck(pasA);
	poortA.procces();
	poortA.locatieOverschrijven(pasA);
	poortA.inchecken(pasA);

	

    }

}
