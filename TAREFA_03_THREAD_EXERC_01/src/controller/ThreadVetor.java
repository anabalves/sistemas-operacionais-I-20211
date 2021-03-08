package controller;

public class ThreadVetor extends Thread {
	private int[] vetor = new int[100];
	private int num;

	public ThreadVetor(int[] vetor, int num) {
		this.vetor = vetor;
		this.num = num;
	}

	@Override
	public void run() {
		calcTempo(vetor, num);
	}

	private void calcTempo(int[] vetor, int num) {
		double tempoInicial = 0;
		double tempoFinal = 0;
		double tempoTotal = 0;

		switch (num) {
		case 1:
			tempoInicial = System.nanoTime();

			for (int aux : vetor);

			tempoFinal = System.nanoTime();
			tempoTotal = tempoFinal - tempoInicial;

			System.out.println("O tempo total da ThreadId#" + getId() + " com foreach " + tempoTotal + "ns.");

			break;

		case 2:
			tempoInicial = System.nanoTime();

			for (int i = 0; i < vetor.length; i++) {
			}

			tempoFinal = System.nanoTime();
			tempoTotal = tempoFinal - tempoInicial;

			System.out.println("O tempo total da ThreadId#" + getId() + " com for " + tempoTotal + "ns.");

			break;
		}
	}

}
