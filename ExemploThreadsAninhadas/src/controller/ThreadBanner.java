package controller;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class ThreadBanner extends Thread {
	private JLabel lblNewLabel;
	private JProgressBar progressBar;
	private JButton btnIniciar;

	public ThreadBanner(JLabel lblNewLabel, JProgressBar progressBar, JButton btnIniciar) {
		this.lblNewLabel = lblNewLabel;
		this.progressBar = progressBar;
		this.btnIniciar = btnIniciar;
	}

	private void geraBanner() {
		btnIniciar.setEnabled(false);
		Thread tBarra = new ThreadProgressBar(progressBar);
		tBarra.start();
		int contador = 1;
		String texto = "";
		while (tBarra.isAlive()) {
			switch (contador) {
			case 1:
				texto = "Boa";
				break;
			case 2:
				texto = "Tarde";
				break;
			case 3:
				texto = "Galera";
			}
			lblNewLabel.setText(texto);
			contador++;
			if (contador == 4) {
				contador = 1;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		btnIniciar.setEnabled(true);
	}

	@Override
	public void run() {
		geraBanner();
	}
}
