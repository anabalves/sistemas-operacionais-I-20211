package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadSJF extends Thread {

	private int idProcesso;
	private Semaphore semaforo;
	private int tempo;
	private static int quantidadeProcessosTerminaram;
	private static int processoVsTempo[][] = new int[20][2];

	public ThreadSJF(int idProcesso, Semaphore semaforo) {
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
		if (quantidadeProcessosTerminaram == 20) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			processosOrdenados();
		}
	}

	private void executaProcesso() {
		tempo = getRandomTime(120, 4);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		processoVsTempo[quantidadeProcessosTerminaram][0] = idProcesso;
		processoVsTempo[quantidadeProcessosTerminaram][1] = tempo;
		quantidadeProcessosTerminaram++;
	}

	private void processosOrdenados() {
		int auxIdProcesso;
		int auxTempos;

		for (int i = 0; i <= 19; i++) {
			for (int j = 0; j <= 18; j++) {
				if (processoVsTempo[i][1] < processoVsTempo[j][1]) {
					auxIdProcesso = processoVsTempo[i][0];
					auxTempos = processoVsTempo[i][1];

					processoVsTempo[i][0] = processoVsTempo[j][0];
					processoVsTempo[i][1] = processoVsTempo[j][1];

					processoVsTempo[j][0] = auxIdProcesso;
					processoVsTempo[j][1] = auxTempos;
				}
			}
		}
		for (int i = 0; i <= 19; i++) {
			System.out.println("\n O processo " + processoVsTempo[i][0] + " está sendo executado a "
					+ (processoVsTempo[i][1] * 1000) + "ms.");
			try {
				sleep(processoVsTempo[i][1]);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("\n O processo " + processoVsTempo[i][0] + " terminou de ser executado");
		}
	}

	public int getRandomTime(int maximo, int minimo) {
		Random rd = new Random();
		int tempo = rd.nextInt(maximo);
		while (tempo < minimo) {
			tempo = rd.nextInt(maximo);
		}
		return tempo;
	}

}