package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadCavaleiros extends Thread {

	private int idCavaleiro;
	private Semaphore semaforoPorta;
	private Semaphore semaforoPedra;
	private Semaphore semaforoTocha;
	public static boolean pegouPedra = true;
	public static boolean pegouTocha = true;
	private final int distanciaTotalCorredor = 2000;
	private int metrosPercorridos = 100;
	private static int portaSeguraAleatoria = getRandom(4, 1);
	private static int portaEscolhida;
	
	public ThreadCavaleiros(int idCavaleiro, Semaphore semaforoPorta, Semaphore semaforoPedra, Semaphore semaforoTocha) {
		this.idCavaleiro = idCavaleiro;
		this.semaforoPorta = semaforoPorta;
		this.semaforoPedra = semaforoPedra;
		this.semaforoTocha = semaforoTocha;
	}

	@Override
	public void run() {
		cavaleirosCaminhando();
		try {
			semaforoPorta.acquire();
			portaEscolhida++;
			escolherPorta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforoPorta.release();
		}
	}

	private void cavaleirosCaminhando() {
		System.out.println("O cavaleiro " + idCavaleiro + " começou a caminhar no corredor");
		int distanciaPercorrida = 0;
		int tempo = 50;
		int aumentaVelocidade = 0;

		while (distanciaPercorrida < distanciaTotalCorredor) {
			
			int deslocamento = getRandom(4, 2);
			distanciaPercorrida += (aumentaVelocidade + deslocamento);

			if (distanciaPercorrida >= 500 && pegouTocha) {
				try {
					semaforoTocha.acquire();
					aumentaVelocidade += 2;
					System.out.println("O cavaleiro " + idCavaleiro + " pegou a tocha");
					pegouTocha = false;
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					semaforoTocha.release();
				}
			}
			
			if (distanciaPercorrida >= 1500 && pegouPedra) {
				try {
					semaforoPedra.acquire();
					aumentaVelocidade += 2;
					System.out.println("O cavaleiro " + idCavaleiro + " pegou a pedra");
					pegouPedra = false;
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					semaforoPedra.release();
				}
			}
			
			if (distanciaPercorrida >= metrosPercorridos ) {
				System.out.println("O cavaleiro " + idCavaleiro + " já caminhou " + distanciaPercorrida + " metros");
				metrosPercorridos += 100;
			}
			
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	private void escolherPorta() {
		System.out.println("O cavaleiro " + idCavaleiro + " chegou na porta " +  portaEscolhida);
		if (portaEscolhida == portaSeguraAleatoria) {
			System.out.println(
					"O cavaleiro " + idCavaleiro + " escolheu a porta " + portaEscolhida + " que leva a saída e viveu");
		} else {
			System.out.println("O cavaleiro " + idCavaleiro + " escolheu a porta " + portaEscolhida
					+ " com o monstro e foi devorado");
		}
	}

	public static int getRandom(int maximo, int minimo) {
		Random rd = new Random();
		return rd.nextInt(maximo - minimo + 1) + minimo;
	}

}