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

	ConectaBD bd = new ConectaBD();

	
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItemNP;
	private JMenuItem menuItemNV;

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

		setExtendedState(MAXIMIZED_BOTH); // Iniciar janela em tela

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Cria e arranja o conteúdo do painel
		setJMenuBar(menuBar);
		
		
		
		//System.out.println(tabelaProdutos.getSelectedRow());
		setVisible(true);
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == menuItemNP) {

			JProduto produto = new JProduto();
		}
		if (e.getSource() == menuItemNV) {
			JVendedor cadastrarVendedor = new JVendedor();
		}
		
	}
}
