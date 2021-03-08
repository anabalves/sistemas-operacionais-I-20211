package controller;

import javax.swing.JProgressBar;

public class ThreadProgressBar extends Thread {
	private JProgressBar progressBar;

	public ThreadProgressBar(JProgressBar progressBar) {
		this.progressBar = progressBar;
	}

	private void preencheBarra() {
		for (int i = 1; i <= 100; i++) {
			progressBar.setValue(i);
			try {
				Thread.sleep(20);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		preencheBarra();
	}
}
