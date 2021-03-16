package controller;

import java.util.concurrent.Semaphore;

public class ThreadServidorMultiprocessamento extends Thread {
	
	private int idThread;
	private Semaphore semaforo;
	private int calcSegIni;
	private int calcSegFim;
	private int repeteRequisicoes;
	private int tempoTransacao;
	
	public ThreadServidorMultiprocessamento(int idThread, Semaphore semaforo, int calcSegIni, int calcSegFim, int repeteRequisicoes, int tempoTransacao) {
		this.idThread = idThread;
		this.semaforo = semaforo;
		this.calcSegIni = calcSegIni;
		this.calcSegFim = calcSegFim;
		this.repeteRequisicoes = repeteRequisicoes;
		this.tempoTransacao = tempoTransacao;
	}

	@Override
	public void run() {
	    for(int i = 0; i < repeteRequisicoes; i++) {
	        calcula();
//			---------------------- Inicio Seção Critica ----------------------
	        try {
	        	semaforo.acquire();
	          transacao();
	        } catch (InterruptedException e) {
	          e.printStackTrace();
	        } finally {
	        	semaforo.release();
	        }
//			---------------------- Fim Seção Critica ----------------------
	    }
	}

	private void calcula() {
		System.out.println("A thread #" + idThread + " está calculando!");
		int tempo = (int) ((Math.random() * calcSegFim) + calcSegIni);		
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("A thread #" + idThread + " finalizou os Cálculos");
	}
	
	private void transacao() {
		System.out.println("A Thread #" + idThread + " está fazendo a transação de banco de dados!");
		try {
			sleep(tempoTransacao);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("A thread #"+ idThread + " finalizou a transação de banco de dados!");
	}

}
