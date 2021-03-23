package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadBanco extends Thread {

	private int codigoConta;
	private float saldoConta;
	private float valor;
	private Semaphore semaforoSaque;
	private Semaphore semaforoDeposito;

	public ThreadBanco(int codigoConta, float saldoConta, float valor, Semaphore semaforoSaque,
			Semaphore semaforoDeposito) {
		this.codigoConta = codigoConta;
		this.saldoConta = saldoConta;
		this.valor = valor;
		this.semaforoSaque = semaforoSaque;
		this.semaforoDeposito = semaforoDeposito;
	}

	@Override
	public void run() {
		if (codigoConta % 2 == 0) {
//			---------------------- Inicio Seção Critica ----------------------
			try {
				semaforoSaque.acquire();
				operacaoSaque();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforoSaque.release();
			} 
//			---------------------- Fim Seção Critica ----------------------		
		} else {
//			---------------------- Inicio Seção Critica ----------------------
			try {
				semaforoDeposito.acquire();
				operacaoDeposito();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforoDeposito.release();
			}
//			---------------------- Fim Seção Critica ----------------------		
		}
	}

	private void operacaoSaque() {
		int tempo = getRandomTempo(2000, 1);
		System.out.println("Iniciando saque na conta " + codigoConta + " no valor de R$ " + valor);
		try {
			Thread.sleep(tempo);
			saldoConta -= valor;
			System.out.println("Saldo atual da conta " + codigoConta + " é de "+ saldoConta);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void operacaoDeposito() {
		int tempo = getRandomTempo(2000, 1);
		System.out.println("Iniciando depósito na conta " + codigoConta  + " no valor de R$ " + valor);
		try {
			Thread.sleep(tempo);
			saldoConta += valor;
			System.out.println("Saldo atual da conta " + codigoConta + " é de "+ saldoConta);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static int getRandomTempo(int maximo, int minimo) {
		Random rd = new Random();
		return rd.nextInt(maximo - minimo + 1) + minimo;
	}
}
