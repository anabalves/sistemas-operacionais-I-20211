package controller;

public class ThreadFatorialNaoRecursivo extends Thread {

	private int num;

	public ThreadFatorialNaoRecursivo(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		double tempoInicial = System.nanoTime();
		int resultado = calculaFatorial(num);
		double tempoFinal = System.nanoTime();
		double tempoTotal = tempoFinal - tempoInicial;
		System.out.println("O fatorial n�o recursivo do n�mero " + num + " levou " + tempoTotal
				+ "ns. para ser calculado e � igual a: " + resultado);
	}

	private int calculaFatorial(int num) {
		int fatorial = 1;
		for (int i = 2; i <= num; i++) {
			fatorial = fatorial * i;
		}
		return fatorial;
	}

}
