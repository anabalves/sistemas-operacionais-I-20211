package view;

import java.util.concurrent.Semaphore;

import controller.ThreadJoKenPo;

public class Principal {

	public static int PontuacaoTimeA;
	public static int PontuacaoTimeB;

	public static void main(String[] args) {

		String timeA[] = { "A1", "A2", "A3", "A4", "A5" };
		String timeB[] = { "B1", "B2", "B3", "B4", "B5" };

		int permissoes = 1;
		Semaphore Pontuacao = new Semaphore(permissoes);

		ThreadJoKenPo duelo1 = new ThreadJoKenPo(timeA[0], timeB[0], Pontuacao);
		duelo1.start();
		ThreadJoKenPo duelo2 = new ThreadJoKenPo(timeA[1], timeB[1], Pontuacao);
		duelo2.start();
		ThreadJoKenPo duelo3 = new ThreadJoKenPo(timeA[2], timeB[2], Pontuacao);
		duelo3.start();
		ThreadJoKenPo duelo4 = new ThreadJoKenPo(timeA[3], timeB[3], Pontuacao);
		duelo4.start();
		ThreadJoKenPo duelo5 = new ThreadJoKenPo(timeA[4], timeB[4], Pontuacao);
		duelo5.start();

		while ((duelo1.isAlive() || duelo2.isAlive() || duelo3.isAlive() || duelo4.isAlive() || duelo5.isAlive())) {
		}
		
		if (PontuacaoTimeA == PontuacaoTimeB) {
			System.out.println("\nO time A e o time B empataram com " + + PontuacaoTimeA + " pontos");
		} else if (PontuacaoTimeA > PontuacaoTimeB) {
			System.out.println("\nO time A ganhou com " + PontuacaoTimeA + " pontos");
			System.err.println("O time B perdeu com " + PontuacaoTimeB + " pontos");
		} else {
			System.out.println("\nO time B ganhou com " + PontuacaoTimeB + " pontos");
			System.err.println("O time A perdeu com " + PontuacaoTimeA + " pontos");
		}
	}

}
