package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import bancoDeDados.ConectaBD;

public class JVenda extends JFrame implements ActionListener {
	private JButton vender;
	private JTable tabelaProdutos;
	private JComboBox<String> v = new JComboBox<String>();
	String[] nomes = null;
	
	/*Objeto que fará conexão com o banco de dados*/
	ConectaBD bd = new ConectaBD();
	
	/*Colunas da tabela*/
	String[] columnNames = { "Tipo", "Tamanho", "Valor", "Quantidade", };
	
	/*Linhas da tabela*/
	Object[][] dados = null;

	public JVenda() {
		
		setLayout(null);
		setSize(800, 500);
		vender = new JButton();
		
		nomes = bd.SelecionaVendedor();
		
		JLabel vendedores = new JLabel("Selecione um Vendedor:");
		
		/*Dimensionado label*/
		vendedores.setBounds(250, 250, 200, 50);
		
		/*Adicionando itens ás linhas*/
		for (int i = 0; i < nomes.length; i++)
		{
			v.addItem(nomes[i]);
		}
		
		v.setBounds(250, 300, 200, 50);
		add(vendedores);
		add(v);

		/*Adicionando botão de vender*/
		vender.setText("Vender");
		vender.addActionListener(this);
		vender.setBounds(250, 350, 100, 50);

		/*Instanciando a tabela de produtos*/
		iniciaTabela();
		
		/*Adicionando barra de rolagem*/
		JScrollPane scroll = new JScrollPane(tabelaProdutos);
		scroll.setBounds(100, 50, 500, 150);
		add(BorderLayout.NORTH, scroll);
		
		add(vender);
		
		setVisible(true);
	}

	/*Atualiza tabela*/
	public void atualizaTabela() {
		
			dados = bd.preencherTabelaProdutos();
			JVenda venda = new JVenda();
			this.dispose();
	}
	/*Instância tabela*/
	public void iniciaTabela(){
		dados = bd.preencherTabelaProdutos();

		tabelaProdutos = new JTable(dados, columnNames);
	}

	/*Executa a função de venda */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vender) {
			
			int res = JOptionPane.showConfirmDialog(null, "Deseja confirmar a venda?");
			if (res == 0) {
				// vender produto.
				Object obj = new Object();
				
				/*Pegando objeto que foi selecionado na tabela pelo usuário*/
				obj = dados[tabelaProdutos.getSelectedRow()][0];
				
				/*informando o usuário sobre o resultado da operação*/
				int result = bd.venderProduto(obj.toString());
				bd.atualizaVendedor(v.getSelectedItem().toString());
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
