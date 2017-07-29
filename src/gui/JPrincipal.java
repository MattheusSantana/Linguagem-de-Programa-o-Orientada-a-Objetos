package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import bancoDeDados.ConectaBD;

//Extends JFrame para referenciar a classe JFrame ao chamar as funções.
public class JPrincipal extends JFrame implements ActionListener {

	ConectaBD bd = new ConectaBD(); // Objeto que chamará os métodos do banco de dados

	
	private JMenuBar menuBar;		//MenuBar Principal.
	private JMenu menu;				//Menu principal.
	private JMenuItem menuItemNP;	//Menu de novo produto.
	private JMenuItem menuItemNV;	//Menu de novo vendedor.
	private JMenuItem menuItemVE;	//Menu de vender produto.
	private JMenuItem menuItemLV;	//Menu de listar vendedores.

	
	public JPrincipal() {
		setLayout(null);

		// Cria a barra de menu
		menuBar = new JMenuBar();

		// Constroi o menu
		menu = new JMenu("Cadastrar");
		menuBar.add(menu);

		menuItemNP = new JMenuItem("Novo Produto");
		menu.add(menuItemNP);

		menuItemNV = new JMenuItem("Novo Vendedor");
		menu.add(menuItemNV);

		menuItemNP.addActionListener(this);

		menuItemNV.addActionListener(this);
		
		menu = new JMenu("Vendas");
		menuBar.add(menu);
		
		menuItemVE = new JMenuItem("Nova Venda");
		menu.add(menuItemVE);
		
		menuItemVE.addActionListener(this);
		
		menu = new JMenu("Vendedores");
		menuBar.add(menu);
		
		menuItemLV = new JMenuItem("Listar Vendedores");
		menu.add(menuItemLV);
		
		menuItemLV.addActionListener(this);
		
		// Iniciar janela em tela
		setExtendedState(MAXIMIZED_BOTH); 

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Cria e arranja o conteúdo do painel
		setJMenuBar(menuBar);
		
	
		setVisible(true);
	}

	
	/*Este método invoca a janela referente á cada menuItem do programa*/
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == menuItemNP) {

			JProduto produto = new JProduto();
		}
		if (e.getSource() == menuItemNV) {
			JVendedor cadastrarVendedor = new JVendedor();
		}
		
		if (e.getSource() == menuItemVE) {
			JVenda venda = new JVenda();
		}
		
		if(e.getSource() == menuItemLV) {
			TabelaVendedor tabelaVendedor = new TabelaVendedor();
		}
	}
}
