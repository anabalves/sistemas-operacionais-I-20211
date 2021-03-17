package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadBilheteria extends Thread {

	private static int quantidadeingressosTotal = 100;
	private int tempoEsperaLogin;
	private int tempoEsperaCompra;
	private int idPessoa;
	private int quantidadeIngressos;
	private Semaphore semaforo;

	public ThreadBilheteria(int idPessoa, int quantidadeIngressos, Semaphore semaforo) {
		this.tempoEsperaLogin = 0;
		this.idPessoa = idPessoa;
		this.quantidadeIngressos = quantidadeIngressos;
		this.semaforo = semaforo;
		this.tempoEsperaCompra = 0;
	}

	@Override
	public void run() {
		if (loginSistema()) {
			if (processoCompra()) {
//				---------------------- Inicio Seção Critica ----------------------
				try {
					semaforo.acquire();
					validacaoCompra();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					semaforo.release();
				}
//					---------------------- Fim Seção Critica ----------------------
			}
		}
	}

	private boolean loginSistema() {
		this.tempoEsperaLogin = getRandomTime(2000, 500);
		try {
			sleep(this.tempoEsperaLogin);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (this.tempoEsperaLogin >= 1000) {
			System.out.println("O cliente #" + idPessoa + " tentou realizar login e recebeu TimeOut após " + this.tempoEsperaLogin + "ms.");
			return false;
		} else {
			System.out.println("O cliente #" + idPessoa + " conseguiu logar no sistema após " + this.tempoEsperaLogin + "ms.");
			return true;
		}
	}

	private boolean processoCompra() {
		this.tempoEsperaCompra = getRandomTime(3000, 1000);
		try {
			sleep(this.tempoEsperaCompra);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (this.tempoEsperaCompra >= 2500) {
			System.out.println("TimeOut: A sessão do cliente #" + idPessoa + " estourou o tempo após " + this.tempoEsperaCompra + "ms. e por isso não poderá fazer a compra :/");
			return false;
		} else {
			System.out.println("O cliente #" + idPessoa + " realizou uma solicitação de compra");
			return true;
		}
	}

	private void validacaoCompra() {
		if (quantidadeingressosTotal - quantidadeIngressos >= 0) {
			quantidadeingressosTotal -= quantidadeIngressos;
			System.out.println("O cliente #" + idPessoa + " conseguiu comprar seus " + quantidadeIngressos + " ingressos");
			System.out.println("Restam apenas " + quantidadeingressosTotal + " ingressos na bilheteria");
		} else {
			System.out.println("O cliente #" + idPessoa + " não conseguiu comprar seus " + quantidadeIngressos + " ingressos pois a quantidade de ingressos na bilheteria é inferior ao número de ingressos solicitados");
		}
	}

	public int getRandomTime(int maximo, int minimo) {
		Random rd = new Random();
		return rd.nextInt(maximo - minimo + 1) + minimo;
	}

}
