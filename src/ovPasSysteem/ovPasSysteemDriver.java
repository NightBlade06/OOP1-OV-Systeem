package ovPasSysteem;

public class ovPasSysteemDriver
{
    public static void main(String[] args)
    {
	ovPasSysteemPas pasA = new ovPasSysteemPas(2030, 10.00); // (geldigTotDatum, saldo) //
	ovPasSysteemPoortOfPaal poortA = new ovPasSysteemPoortOfPaal("Nijmegen", true, 2026); // (locatie , poort, huidigJaar) //

	poortA.validiteitCheck(pasA);
	poortA.saldoCheck(pasA);
	poortA.inchecken(pasA);

	

    }

}
