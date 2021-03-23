package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadCorredores extends Thread {

	private Semaphore semaforo;
	private int idCorredor;
	private int tempoCorredor;
	private int tempoAbrirPorta;
	private int metrosPorSegundo;
	private static int posicao;

	public ThreadCorredores(int idCorredor, Semaphore semaforo) {
		this.idCorredor = idCorredor;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		caminhando();
//		---------------------- Inicio Seção Critica ----------------------
		try {
			semaforo.acquire();
			abrirCruzarPorta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
			posicao++;
			System.out.println("O corredor " + idCorredor + " chegou em " + posicao + "° lugar caminhando por " + tempoCorredor
					+ " segundos, levando " + tempoAbrirPorta + " segundo(s) para abrir e cruzar a porta");
		}
//		---------------------- Fim Seção Critica ----------------------		
	}

	private void caminhando() {
		metrosPorSegundo = getRandomTime(6, 4);
		int distancia = 0;
		System.out.println("O corredor " + idCorredor + " está andando à " + metrosPorSegundo + "m/s");
		while (distancia < 200) {
			distancia += metrosPorSegundo;
			tempoCorredor += 1;
			System.out.println("O corredor " + idCorredor + " caminhou "+ distancia + " m/s.");
		}
		System.out.println("O corredor " + idCorredor + " chegou a porta.");
		
	}

	private void abrirCruzarPorta() {
		System.out.println("O corredor " + idCorredor + " está abrindo a porta.");
		tempoAbrirPorta = getRandomTime(2, 1);
		try {
			sleep(tempoAbrirPorta * 1000);
			System.out.println("O corredor " + idCorredor + " cruzou a porta.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getRandomTime(int maximo, int minimo) {
		Random rd = new Random();
		return rd.nextInt(maximo - minimo + 1) + minimo;
	}

}
