package controller;

public class SapoThread extends Thread {

	private int distanciaMaxima;
	private int saltoParcial;
	private int saltoTotal;
	private boolean fimCorrida;
	private int totalCorrida = 80;
	private int posicao = 1;
	
	public SapoThread(int i) {
		this.distanciaMaxima = 0;
		this.saltoParcial = 0;
		this.saltoTotal = 0;
		this.fimCorrida = false;
	}

	@Override
	public void run() {
		corrida();
	}

	public void corrida() {
		while (!fimCorrida) {
			saltoParcial = getRandomNumber();
			saltoTotal++;
			distanciaMaxima += saltoParcial;
			System.out.println("O sapo " + getId() + " saltou " + saltoParcial + " metros e percorreu no total " + distanciaMaxima + " metros");
			System.out.println();
			fimCorrida = ranking(distanciaMaxima, getId(), fimCorrida, saltoTotal);
			aguardar();
		}

	}

	public boolean ranking(int distanciaMaxima, long sapoId, boolean fimCorrida, int saltoTotal) {
		if (distanciaMaxima >= totalCorrida) {
				System.out.println();
				System.out.println("\n---------------------------O SAPO " +  sapoId + " TERMINOU EM " + posicao + "° LUGAR------------------------------");
				System.out.println("O sapo " + sapoId + " chegou na " +  posicao + "° posicao com " + saltoTotal+ " saltos, percorrendo " + distanciaMaxima + " metros");
				System.out.println("---------------------------------------------------------------------------------------");
				System.out.println();
				posicao = posicao + 1;
				return true;        
		}
		return false;
	}
	
	private void aguardar() {
		int aguardar = (int) ((Math.random() * (50 - 1) + 50));
		try {
			sleep(aguardar);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static int getRandomNumber() {
		return (int) ((Math.random() * (10 - 1) + 1));
	}

}
