package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

public class BolinhaController implements ActionListener {
	private JLabel lblBolinha1;
	private JLabel lblBolinha2;
	private JButton btnIniciar;

	public BolinhaController(JLabel lblBolinha1, JLabel lblBolinha2, JButton btnIniciar) {
		this.lblBolinha1 = lblBolinha1;
		this.lblBolinha2 = lblBolinha2;
		this.btnIniciar = btnIniciar;
	}

	private void botaoBolinha() {
		Thread t1 = new ThreadBolinha(lblBolinha1, btnIniciar);
		Thread t2 = new ThreadBolinha(lblBolinha2, btnIniciar);
		t1.start();
		t2.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		botaoBolinha();
	}
}
