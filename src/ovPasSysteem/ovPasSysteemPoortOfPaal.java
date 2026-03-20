package ovPasSysteem;

public class ovPasSysteemPoortOfPaal
{
    // Fields

   private String locatie;
   private boolean processKlaar = false;
   private boolean poort;
   private int huidigJaar;

    // Constructor

    public ovPasSysteemPoortOfPaal(String locatie, boolean poort, int huidigJaar)
    {
	this.locatie = locatie;
	this.poort = poort;
	this.huidigJaar = huidigJaar;
    }

    // Methods

    public void locatieOverschrijven(ovPasSysteemPas ovPas)
    {
	ovPas.setHuidigelocatie(this.locatie);

	// ovPas.rekeningWaarde = ovPas.rekeningWaarde + 1;
    }

    public void inchecken(ovPasSysteemPas ovPas)
    {
	if (processKlaar == true && poort)
	{
	    ovPas.setStatusIncheck(true);
	    System.out.printf("U bent ingecheckt op " + locatie);
	    openPoort();
	}

	else if (processKlaar == true)
	{
	    locatieOverschrijven(ovPas);
	    ovPas.setStatusIncheck(true);
	    
	    System.out.printf("U bent ingecheckt op " + locatie);
	} else
	{
	    System.out.println("Er is iets mis gegaan met inchecken.");
	}
    }

    public void validiteitCheck(ovPasSysteemPas ovPas)
    {
	if (huidigJaar > ovPas.getGeldigTotDatum())
	{
	    System.out.print("Uw ov-pas is verlopen haal z.s.m een nieuwe om weer te kunnen reizen.");
	    quitProgram();
	}

    }

    public void saldoCheck(ovPasSysteemPas ovPas)
    {
	if (ovPas.getSaldo() < 10.00)
	{
	    System.out.print("Uw saldo is te laag zet meer saldo op je ov-pas om weer te kunnen reizen.");
	    // methode om te starten van oplaad automaat
	    quitProgram();
	} else
	{
	    processKlaar = true;
	}

    }

    public void openPoort()
    {
	if (poort == true)
	{
	    System.out.print("de poort is open");
	}

    }

    public void quitProgram()
    {
	System.exit(0);
    }

}
