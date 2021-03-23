package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadCruzamento extends Thread {

	private int idCarro;
	private Semaphore semaforo;
	private String[] sentido = { "Rua de Baixo para Rua de Cima", "Rua de Cima para Rua de Baixo",
			"Rua da Esquerda para a Rua da Direita", "Rua da Direita para a Rua da Esquerda" };
	private String[] sentidos = { "Rua de Cima", "Rua de Baixo", "Rua da Direita", "Rua da Esquerda" };
	private static int sentido1 = 0;
	private static int posicao = 1;

	public ThreadCruzamento(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
//		---------------------- Inicio Seção Critica ----------------------
		try {
			semaforo.acquire();
			cruzamento();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			posicao++;
			semaforo.release();
		}
//		---------------------- Fim Seção Critica ----------------------		
	}

	private void cruzamento() {
		System.out.println("O carro " + idCarro + " está esperando para iniciar o cruzamento");
		Deslocamento();
		System.out.println("O carro " + idCarro + " cruzou a rua e chegou na " + sentidos[sentido1]);
		sentido1++;
	}

	private void Deslocamento() {
		System.out.println("O carro " + idCarro + " foi o " + posicao + "º a iniciar o cruzamento da " + sentido[sentido1]);
		int tempo = getRandomTime(1000, 1);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getRandomTime(int maximo, int minimo) {
		Random rd = new Random();
		return rd.nextInt(maximo - minimo + 1) + minimo;
	}

}
