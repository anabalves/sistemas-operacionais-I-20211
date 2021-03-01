package controller;

public class OperacoesController {
	
	public OperacoesController() {
		super();
	}

	public void percorreVetor1000() {
		int vetor1000[] = new int[1000];
		double tempoInicial = System.nanoTime(); 
		for (int i : vetor1000) {}
		double tempoFinal = System.nanoTime();
		double tempoTotal = tempoFinal - tempoInicial;
		System.out.println("Vetor 1000 ==> " + tempoTotal + "ns.");
	}
	
	public void percorreVetor10000() {
		int vetor10000[] = new int[10000];
		double tempoInicial = System.nanoTime(); 
		for (int i : vetor10000) {}
		double tempoFinal = System.nanoTime();
		double tempoTotal = tempoFinal - tempoInicial;
		System.out.println("Vetor 10000 ==> " + tempoTotal + "ns.");
	}
	
	public void percorreVetor100000() {
		int vetor100000[] = new int[100000];
		double tempoInicial = System.nanoTime(); 
		for (int i : vetor100000) {}
		double tempoFinal = System.nanoTime();
		double tempoTotal = tempoFinal - tempoInicial;
		System.out.println("Vetor 100000 ==> " + tempoTotal + "ns.");
	}
}