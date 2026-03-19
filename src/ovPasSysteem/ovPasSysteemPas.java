package ovPasSysteem;

public class ovPasSysteemPas
{
    int pasNr;
    int geldigTotDatum;
    double saldo;
    double rekeningWaarde;
    boolean statusIncheck;
    String huidigeLocatie;

    public ovPasSysteemPas(int datum, double saldo)
    {
	this.geldigTotDatum = datum;
	this.saldo = saldo;
    }
}
