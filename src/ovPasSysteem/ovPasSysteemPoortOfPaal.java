package ovPasSysteem;

public class ovPasSysteemPoortOfPaal
{
    // Fields

    private String locatie;
    private boolean processKlaar = false;
    private boolean poort;
    private int huidigJaar;
    private double reisTarief;

    // Constructor

    public ovPasSysteemPoortOfPaal(String locatie, boolean poort, int huidigJaar)
    {
	this.locatie = locatie;
	this.poort = poort;
	this.huidigJaar = huidigJaar;
    }

    // Methods algemeen (voor incheck en uitcheck)

    public void locatieOverschrijven(ovPasSysteemPas ovPas)
    {
	ovPas.setHuidigelocatie(this.locatie);

	ovPas.setRekeningWaarde(ovPas.getRekeningWaarde() + 1);
    }

    public void validiteitCheck(ovPasSysteemPas ovPas)
    {
	if (huidigJaar > ovPas.getGeldigTotDatum())
	{
	    System.out.println("Uw ov-pas is verlopen haal z.s.m een nieuwe om weer te kunnen reizen.");
	    quitProgram();
	}

    }

    public void openPoort()
    {
	if (poort == true)
	{
	    System.out.println("de poort is open");
	}

    }

    public void quitProgram()
    {
	System.exit(0);
    }

    // Methods incheck (methodes die alleen bij inchecken gelden)

    public void saldoCheck(ovPasSysteemPas ovPas)
    {
	if (ovPas.getSaldo() < 10.00)
	{
	    System.out.println("Uw saldo is te laag zet meer saldo op je ov-pas om weer te kunnen reizen.");
	    // methode om te starten van oplaad automaat
	    quitProgram(); // deze moet weg later
	} else
	{
	    processKlaar = true;
	}

    }

    public void inChecken(ovPasSysteemPas ovPas)
    {
	if (processKlaar == true && ovPas.getStatusIncheck() == false)
	{
	    locatieOverschrijven(ovPas);
	    ovPas.setStatusIncheck(true);
	    System.out.println("U bent ingecheckt op " + locatie);
	    if (poort == true)
	    {
		openPoort();
	    }
	}

	else
	{
	    System.out.println("Er is iets mis gegaan met inchecken.");
	}
    }

    // Methods uitcheck (methodes die alleen bij uitchecken gelden)

    public void uitChecken(ovPasSysteemPas ovPas)
    {
	if (processKlaar == true && ovPas.getStatusIncheck() == true)
	{
	    locatieOverschrijven(ovPas);
	    ovPas.setStatusIncheck(false);
	    System.out.println("dit is uw huidige saldo: €" + ovPas.getSaldo());
	    System.out.println("U bent uitgecheckt op " + locatie);
	    if (poort == true)
	    {
		openPoort();
	    }
	}

	else
	{
	    System.out.println("Er is iets mis gegaan met uitchecken.");
	}
    }

    public void berekenBetaling(ovPasSysteemPas ovPas)
    {
	reisTarief = 2.00 + (ovPas.getRekeningWaarde() * 0.75);
	ovPas.setSaldo(ovPas.getSaldo() - reisTarief);
	processKlaar = true;
    }

}
