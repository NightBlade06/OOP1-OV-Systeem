package ovPasSysteem;

public class ovPasSysteemReiziger
{
    String naam;
    double bankRekening;

    public ovPasSysteemReiziger(double bankRekening)
    {
	this.bankRekening = bankRekening;
    }

    public double getBankRekening() {
	return this.bankRekening;
    }
    
    public void setBankRekening(double bankRekening) {
	this.bankRekening = bankRekening;
    }
}
