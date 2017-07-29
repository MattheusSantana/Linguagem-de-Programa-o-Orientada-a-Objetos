package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import bancoDeDados.ConectaBD;

public class TabelaVendedor extends JFrame{
	/*Colunas da tabela*/
	String[] columnNames = { "nome", "Salário", "Quantidade de Vendas", "Taxa de Comissão"};
	
	/*Linhas da tabela*/
	Object[][] dados = null;
	
	private JTable tabela;
	ConectaBD bd = new ConectaBD();
	
	
	public TabelaVendedor(){
		setLayout(null);
		setSize(800, 500);
		JLabel titulo = new JLabel("Lista de vendedores");
		titulo.setBounds(100, 30, 150, 20);
		
		
		add(titulo);
		iniciaTabela();
		
		
		JScrollPane scroll = new JScrollPane(tabela);
		scroll.setBounds(100, 50, 500, 150);
		add(BorderLayout.NORTH, scroll);
		setVisible(true);
	}
	
	/*Atualiza tabela*/
	public void atualizaTabela() {
		
		dados = bd.preencherTabelaVendedor();
		TabelaVendedor tabela = new TabelaVendedor();
		this.dispose();
}
	/*Instância tabela*/
	public void iniciaTabela(){
		dados = bd.preencherTabelaVendedor();
		tabela = new JTable(dados, columnNames);
	}
	
	

}
