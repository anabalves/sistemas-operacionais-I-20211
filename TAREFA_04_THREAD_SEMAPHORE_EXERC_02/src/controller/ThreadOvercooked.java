package controller;

import java.util.concurrent.Semaphore;

public class ThreadOvercooked extends Thread {

	private final int idPrato;
	private final Semaphore semaforo;
	private final String nomePrato;
	private final int calcSegIni;
	private final int calcSegFim;
	private float tempoPreparo;

	public ThreadOvercooked(int idPrato, Semaphore semaforo, String nomePrato, int calcSegIni, int calcSegFim) {
		super();
		this.idPrato = idPrato;
		this.semaforo = semaforo;
		this.nomePrato = nomePrato;
		this.calcSegIni = calcSegIni;
		this.calcSegFim = calcSegFim;
	}

	@Override
	public void run() {
		cozinhando();
		tempoPreparo();
		percentualCozimento();
//		---------------------- Inicio Seção Critica ----------------------
		try {
			semaforo.acquire();
			entregaPrato();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("O prato #" + idPrato + " " + nomePrato + " foi entregue!");
			semaforo.release();
		}
//		---------------------- Fim Seção Critica ----------------------
	}

	private void cozinhando() {
		System.out.println("O prato #" + idPrato + " " + nomePrato + " começou a ser preparado!");
	}

	private void tempoPreparo() {
		tempoPreparo = (int) ((Math.random() * calcSegIni) + calcSegFim);

		try {
			sleep((int) tempoPreparo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void percentualCozimento() {
		int tempo = 100;
		int percentualCozimento = 0;
		while (percentualCozimento < 100) {
			percentualCozimento += (int) (tempoPreparo / 100);
			System.out.println(
					"O prato #" + idPrato + " " + nomePrato + " já está " + percentualCozimento + "% concluído!");

			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void entregaPrato() {
		int tempo = 500;
		System.out.println("O prato #" + idPrato + " " + nomePrato + " está pronto para ser entregue!");
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
