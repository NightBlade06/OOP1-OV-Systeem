package ovPasSysteem;

public class ovPasSysteemPas
{
   // Fields
    
   private int geldigTotDatum;
   private double saldo;
   private double rekeningWaarde;
   private boolean statusIncheck;
   private String huidigeLocatie;
   
   // Constructor

   public ovPasSysteemPas(int datum, double saldo, boolean statusIncheck)
   {
       this.geldigTotDatum = datum;
       this.saldo = saldo;
       this.statusIncheck = statusIncheck;
   }
    
 // Methods (Set / Get)
    
    public int getGeldigTotDatum() {
	return this.geldigTotDatum;
    }
    
    public double getSaldo() {
	return this.saldo;
    }
    
    public void setSaldo(double saldo) {
	this.saldo = saldo;
    }
    
    public double getRekeningWaarde() {
	return this.rekeningWaarde;
    }
    
    public void setRekeningWaarde(double rekeningWaarde) {
	this.rekeningWaarde = rekeningWaarde;
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
