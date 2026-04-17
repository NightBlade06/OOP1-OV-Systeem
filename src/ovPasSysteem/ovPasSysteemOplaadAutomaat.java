package ovPasSysteem;

public class ovPasSysteemOplaadAutomaat
{
    double userInput;
    private double geldOpslag;
    private boolean processAutomaatKlaar = false;
    
    // set / gets
    
    public boolean getProccesAutomaatKlaar() {
	return this.processAutomaatKlaar;
    }
    
    public void setProccesKlaar(boolean proccesAutomaatKlaar) {
	this.processAutomaatKlaar = proccesAutomaatKlaar;
    }
    
    public ovPasSysteemOplaadAutomaat(double userInput)
    {
	this.userInput = userInput;
    }

    public void bankAftrekken(ovPasSysteemReiziger reiziger)
    {
	if (reiziger.getBankRekening() <= userInput)
	{
	    reiziger.setBankRekening(reiziger.getBankRekening() - userInput);
	   geldOpslag = userInput;
	} else
	{

	}
    }
    
    public void opwaderen(ovPasSysteemPas ovPas)
    {
	ovPas.setSaldo(ovPas.getSaldo() + geldOpslag);

    }
}
