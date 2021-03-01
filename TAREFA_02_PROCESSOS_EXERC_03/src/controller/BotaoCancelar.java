package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TelaExecutar;

public class BotaoCancelar implements ActionListener {

	private TelaExecutar telaExecutar;

	public BotaoCancelar(TelaExecutar telaExecutar) {
		this.telaExecutar = telaExecutar;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		telaExecutar.dispose();
	}

}
