package controller;

import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ThreadBolinha extends Thread {
	private JLabel lblBolinha;
	private JButton btnIniciar;

	public ThreadBolinha(JLabel lblBolinha, JButton btnIniciar) {
		this.lblBolinha = lblBolinha;
		this.btnIniciar = btnIniciar;
	}

	private void mexeBolinha() {
		btnIniciar.setEnabled(false);
		Rectangle posicao;
		posicao = lblBolinha.getBounds();
		lblBolinha.setBounds(posicao);
		int contadorDeMov = 0;
		while (contadorDeMov <= 12) {
			if (contadorDeMov <= 2) {
				posicao.y = posicao.y + 10;
			} else {
				if (contadorDeMov > 2 && contadorDeMov <= 6) {
					posicao.x = posicao.x + 20;
				} else {
					if (contadorDeMov > 6 && contadorDeMov <= 9) {
						posicao.y = posicao.y - 10;
					} else {
						if (contadorDeMov > 9 && contadorDeMov <= 12) {
							posicao.x = posicao.x - 20;
						}
					}
				}
			}
			lblBolinha.setBounds(posicao);
			try {
				Thread.sleep(500);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			contadorDeMov++;
		}
		btnIniciar.setEnabled(true);
	}

	@Override
	public void run() {
		mexeBolinha();
	}
}
