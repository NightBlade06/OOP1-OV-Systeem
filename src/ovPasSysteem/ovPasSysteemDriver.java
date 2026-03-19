package ovPasSysteem;

public class ovPasSysteemDriver
{
    public static void main(String[] args)
    {
	ovPasSysteemPas pasA = new ovPasSysteemPas(2030, 20.00);
	ovPasSysteemPoortOfPaal poortA = new ovPasSysteemPoortOfPaal("Nijmegen", false, 2026);

	poortA.validiteitCheck(pasA);
	poortA.saldoCheck(pasA);
	poortA.procces();
	poortA.locatieOverschrijven(pasA);
	poortA.inchecken(pasA);

	

    }

}
