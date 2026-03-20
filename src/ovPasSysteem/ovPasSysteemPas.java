package ovPasSysteem;

public class ovPasSysteemPas
{
   private int pasNr;
   private int geldigTotDatum;
   private double saldo;
   private double rekeningWaarde;
   private boolean statusIncheck;
   private String huidigeLocatie;

    public ovPasSysteemPas(int datum, double saldo)
    {
	this.geldigTotDatum = datum;
	this.saldo = saldo;
    }
    
    public int getPasNr() {
	return this.pasNr;
    }
    
    public int getGeldigTotDatum() {
	return this.geldigTotDatum;
    }
    
    public double getSaldo() {
	return this.saldo;
    }
    
    public double getRekeningWaarde() {
	return this.rekeningWaarde;
    }
    
    public boolean getStatusIncheck() {
	return this.statusIncheck;
    }
    
    public void setStatusIncheck(boolean statusIncheck) {
	this.statusIncheck = statusIncheck ;
    }
    
    public String getHuidigeLocatie() {
	return this.huidigeLocatie;
    }
    
    public void setHuidigelocatie(String nieuweLocatie) {
	this.huidigeLocatie = nieuweLocatie;
    }
}
