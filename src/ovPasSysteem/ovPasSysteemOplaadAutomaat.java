package ovPasSysteem;

public class ovPasSysteemOplaadAutomaat
{
    double userInput;
    private double geldOpslag;
    private boolean processAutomaatKlaar = false;
    private boolean vraagAutomaatKlaar = false;
    private boolean bankAutomaatKlaar = false;

    // set / gets
    
    public boolean getBankAutomaatKlaar()
    {
	return this.bankAutomaatKlaar;
    }

    public void setBankAutomaatKlaar(boolean bankAutomaatKlaar)
    {
	this.bankAutomaatKlaar = bankAutomaatKlaar;
    }

    public boolean getVraagAutomaatKlaar()
    {
	return this.vraagAutomaatKlaar;
    }

    public void setVraagAutomaatKlaar(boolean vraagAutomaatKlaar)
    {
	this.vraagAutomaatKlaar = vraagAutomaatKlaar;
    }
    
    public boolean getProccesAutomaatKlaar()
    {
	return this.processAutomaatKlaar;
    }

    public void setProccesAutomaatKlaar(boolean proccesAutomaatKlaar)
    {
	this.processAutomaatKlaar = proccesAutomaatKlaar;
    }

    public double getUserInput()
    {
	return this.userInput;
    }

    public void setUserInput(double userInput)
    {
	this.userInput = userInput;
    }

    public void bankAftrekken(ovPasSysteemReiziger reiziger)
    {
	if (reiziger.getBankRekening() >= userInput)
	{
	    reiziger.setBankRekening(reiziger.getBankRekening() - userInput);
	    geldOpslag = userInput;
	    setBankAutomaatKlaar(true);
	} else
	{
	    System.out.println("Er is iets mis gegaan met geld overschrijven van uw bank naar ovpas.");
	}

    }

    public void opwaarderen(ovPasSysteemPas ovPas)
    {
	if(getBankAutomaatKlaar() == true) {
	    ovPas.setSaldo(ovPas.getSaldo() + geldOpslag);
		setProccesAutomaatKlaar(true);  
	}
	
	else {
	    System.out.println("Er is iets mis gegaan met geld overschrijven van de automaat naar uw ovpas.");
	}

    }
}
