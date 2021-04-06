package controller;

public class ThreadFatorialRecursivo extends Thread {

	private int num;

	public ThreadFatorialRecursivo(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		double tempoInicial = System.nanoTime();
		int resultado = calculaFatorial(num);
		double tempoFinal = System.nanoTime();
		double tempoTotal = tempoFinal - tempoInicial;
		System.out.println("O fatorial recursivo do número " + num + " levou " + tempoTotal
				+ "ns. para ser calculado e é igual a: " + resultado);
	}

	private int calculaFatorial(int num) {
		if (num == 0)
			return 1;
		else
			return num * calculaFatorial(num - 1);
	}

}
