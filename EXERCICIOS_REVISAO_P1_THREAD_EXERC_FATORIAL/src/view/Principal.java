package view;

import javax.swing.JOptionPane;

import controller.ThreadFatorialNaoRecursivo;
import controller.ThreadFatorialRecursivo;

public class Principal {

	public static void main(String[] args) {
		int num;
		do {
			num = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro positivo para calcular seu fatorial"));
		} while (num < 0);
		
		ThreadFatorialRecursivo threadFatorialRecursivo = new ThreadFatorialRecursivo(num);
		threadFatorialRecursivo.start();
		ThreadFatorialNaoRecursivo threadFatorialNaoRecursivo = new ThreadFatorialNaoRecursivo(num);
		threadFatorialNaoRecursivo.start();
	}

}
