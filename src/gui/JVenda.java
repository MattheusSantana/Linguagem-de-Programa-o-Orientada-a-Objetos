package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import bancoDeDados.ConectaBD;

public class JVenda extends JFrame implements ActionListener {
	private JButton vender;
	private JTable tabelaProdutos;
	ConectaBD bd = new ConectaBD();
	String[] columnNames = { "Tipo", "Tamanho", "Valor", "Quantidade", };
	Object[][] dados = null;

	public JVenda() {
		
		setLayout(null);
		setSize(800, 500);
		vender = new JButton();

		vender.setText("Vender");
		vender.addActionListener(this);
		vender.setBounds(250, 250, 100, 50);

		iniciaTabela();
		JScrollPane scroll = new JScrollPane(tabelaProdutos);
		scroll.setBounds(100, 50, 500, 150);
		add(BorderLayout.NORTH, scroll);
		
		add(vender);
		
		setVisible(true);
	}

	public void atualizaTabela() {
		
			dados = bd.preencherTabelaProdutos();
			JVenda venda = new JVenda();
			this.dispose();
	}
	public void iniciaTabela(){
		dados = bd.preencherTabelaProdutos();

		tabelaProdutos = new JTable(dados, columnNames);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vender) {
			
			int res = JOptionPane.showConfirmDialog(null, "Deseja confirmar a venda?");
			if (res == 0) {
				// vender produto.
				Object obj = new Object();
				obj = dados[tabelaProdutos.getSelectedRow()][0];
				int result = bd.venderProduto(obj.toString());
				if (result == 1) {
					JOptionPane.showMessageDialog(null, "PARABENS! Você efetuou uma venda =)");
					atualizaTabela();
				} else if (result == 0)
					JOptionPane.showMessageDialog(null, "Não há produtos disponiveis para a venda");
				else
					JOptionPane.showMessageDialog(null, "Erro ao efetuar a venda!");
			}

		}

	}
}
