package view;

import java.util.Random;
import java.util.concurrent.Semaphore;

import controller.ThreadBanco;

public class Principal {
	
	public static Semaphore semaforoSaque, semaforoDeposito;
	private static int codigoConta;
	private static float saldoConta;
	private static float valor;

	public static void main(String[] args) {
		
		int permissoesSaque = 1;
		Semaphore semaforoSaque = new Semaphore(permissoesSaque);
		
		int permissoesDeposito = 1;
		Semaphore semaforoDeposito = new Semaphore(permissoesDeposito);

		for (codigoConta = 1; codigoConta <= 20; codigoConta++) {
			saldoConta = getRandom(10000, 1);
			valor = getRandom(1000, 100);
			ThreadBanco threadBanco = new ThreadBanco(codigoConta, saldoConta, valor, semaforoSaque, semaforoDeposito);
			threadBanco.start();
		}

	}
	
	public static float getRandom(int maximo, int minimo) {
		Random rd = new Random();
		return rd.nextInt(maximo - minimo + 1) + minimo;
	}

}
