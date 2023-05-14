package lab;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int duzina;
		int broj;
		Scanner s = new Scanner (System.in);
		System.out.println("Unesite duzinu signala"); //unosimo duzinu signala
		duzina = s.nextInt();
		Signal A = new Signal(0.2, duzina);
		Signal B = new Signal(0.3, duzina);
		Signal C = new Signal(0.4, duzina);
		
		System.out.println("Unesite verovatnocu dogadjaja A");
		A.postVerovatnocu(s.nextDouble());
//		System.out.println("Unesite procenat jedinica u singalu A");
//		double v = s.nextDouble();
//		if(v > 1) throw new IllegalArgumentException();
//		A.postProcenat(s.nextDouble());
		
		System.out.println("Unesite verovatnocu dogadjaja B");
		B.postVerovatnocu(s.nextDouble());
//		System.out.println("Unesite procenat jedinica u singalu B");
//		v = s.nextDouble();
//		if(v > 1 - A.verovatnoca) throw new IllegalArgumentException();
//		B.postProcenat(s.nextDouble());
		
		System.out.println("Unesite verovatnocu dogadjaja C");
		C.postVerovatnocu(s.nextDouble());
//		System.out.println("Unesite procenat jedinica u singalu C");
//		v = s.nextDouble();
//		if(v != 1 - A.verovatnoca - B.verovatnoca) throw new IllegalArgumentException();
//		C.postProcenat(s.nextDouble());
		System.out.println("Br iter|Broj jed|A \t\t B \t\t C");
		int i = 0;
		System.out.printf("%d \t / \t %.4f \t %.4f \t %.4f \n", i, A.verovatnoca, B.verovatnoca, C.verovatnoca);
		while(true) {
			if(A.verovatnoca > 0.99) break;
			if(B.verovatnoca > 0.99) break;
			if(C.verovatnoca > 0.99) break;
			i++;
			broj = (int) (Math.random() * (duzina + 1));
			A.postBroj(broj);
			B.postBroj(broj);
			C.postBroj(broj);
			Signal.aposteriornaVer(A, B, C);
			System.out.printf("%d \t %d \t %.4f \t %.4f \t %.4f \n", i, broj, A.verovatnoca, B.verovatnoca, C.verovatnoca);
		}
		if(A.verovatnoca > 0.99) System.out.print("Trazeni signal je tipa A.");
		if(B.verovatnoca > 0.99) System.out.print("Trazeni signal je tipa B.");
		if(C.verovatnoca > 0.99) System.out.print("Trazeni signal je tipa C.");
		s.close();
	}

}
