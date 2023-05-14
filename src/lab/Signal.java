package lab;

public class Signal {

	protected double verovatnoca; // apriorna verovatnoca
	protected double procenat; // verovatnoca da sadrzi 1
	protected int broj;
	protected int duzina;
	
	public Signal(double procenat1, int duzina) {
		super();
		this.procenat = procenat1;
		this.duzina = duzina;
	}
	
	public void postVerovatnocu(double verovatnoca) {
		if(verovatnoca > 1) throw new IllegalArgumentException();
		this.verovatnoca = verovatnoca;
	}
	
	public void postProcenat(double procenat) {
		if(procenat > 1) throw new IllegalArgumentException();
		this.procenat = procenat;
	}

	public void postBroj(int broj) {
		this.broj = broj;
	}

	//izracunavanje P(D|Hi)
	public double uslovnaVer () {
		int a = 210; // a je  vrednost 10 nad 4 (od 10 mesta na 4 su jedinice, na ostalim mestima su nule)
		double b = Math.pow(this.procenat, broj); // b - na 4 mesta se nalaze jedinice, njihova verovatnoca (procenat1) nam govori kolike su sanse da padne
		double c = Math.pow(1 - this.procenat, 10 - broj); // c - na preostalih 6 mesta su nule, njihova verovatnoca je (1 - procenat1)
		return a * b * c;
	}
	
	public static void aposteriornaVer (Signal a, Signal b, Signal c) {
		double a1, b1, c1;
		a1 = a.verovatnoca;
		b1 = b.verovatnoca;
		c1 = c.verovatnoca;
		double a2, b2, c2;
		
		a2 = (a1 * a.uslovnaVer())/(a1 * a.uslovnaVer() + b1 * b.uslovnaVer() + c1 * c.uslovnaVer());
		b2 = (b1 * b.uslovnaVer())/(a1 * a.uslovnaVer() + b1 * b.uslovnaVer() + c1 * c.uslovnaVer());
		c2 = (c1 * c.uslovnaVer())/(a1 * a.uslovnaVer() + b1 * b.uslovnaVer() + c1 * c.uslovnaVer());
		a.postVerovatnocu(a2);
		b.postVerovatnocu(b2);
		c.postVerovatnocu(c2); 
	}
}
