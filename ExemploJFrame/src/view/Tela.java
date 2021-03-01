package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import controller.PessoaController;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfPessoa;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfPessoa = new JTextField();
		tfPessoa.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		tfPessoa.setBounds(84, 45, 400, 20);
		contentPane.add(tfPessoa);
		tfPessoa.setColumns(10);
		
		JLabel lblPessoa = new JLabel("Pessoa");
		lblPessoa.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		lblPessoa.setBounds(10, 45, 80, 20);
		contentPane.add(lblPessoa);
		
		NumberFormat numberFormat = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(numberFormat);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(0);
		formatter.setMaximum(99);
		formatter.setAllowsInvalid(false);
		
		JFormattedTextField tfPosicao = new JFormattedTextField(formatter);
		tfPosicao.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		tfPosicao.setBounds(84, 100, 100, 20);
		contentPane.add(tfPosicao);
		
		JLabel lblPosicao = new JLabel("Posi\u00E7\u00E3o");
		lblPosicao.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		lblPosicao.setBounds(10, 102, 67, 17);
		contentPane.add(lblPosicao);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		btnAdicionar.setBounds(10, 160, 90, 24);
		contentPane.add(btnAdicionar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		btnExcluir.setBounds(140, 160, 90, 24);
		contentPane.add(btnExcluir);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		btnConsultar.setBounds(267, 160, 90, 24);
		contentPane.add(btnConsultar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		btnListar.setBounds(394, 160, 90, 24);
		contentPane.add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 195, 471, 295);
		contentPane.add(scrollPane);
		
		JTextArea taLista = new JTextArea();
		taLista.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		scrollPane.setViewportView(taLista);
		
		PessoaController pessoaController = new PessoaController(tfPessoa, tfPosicao, taLista);
		btnAdicionar.addActionListener(pessoaController);
		btnExcluir.addActionListener(pessoaController);
		btnConsultar.addActionListener(pessoaController);
		btnListar.addActionListener(pessoaController);
	}
}
