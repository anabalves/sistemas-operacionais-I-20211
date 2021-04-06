package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadFCFS extends Thread {

	private int idProcesso;
	private Semaphore semaforo;

	public ThreadFCFS(int idProcesso, Semaphore semaforo) {
		this.idProcesso = idProcesso;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
//		---------------------- Inicio Seção Critica ----------------------
		try {
			semaforo.acquire();
			executaProcesso();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
//		---------------------- Fim Seção Critica ----------------------	
	}


	private void executaProcesso() {
		int tempo = getRandomTime(120, 4);
		System.out.println("O processo " + idProcesso + " está sendo executado a " + (tempo*1000) + "ms");
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O processo " + idProcesso + " terminou de ser executado");
	}
	
	public int getRandomTime(int maximo, int minimo) {
		Random rd = new Random();
		return rd.nextInt(maximo - minimo + 1) + minimo;
	}
	
}