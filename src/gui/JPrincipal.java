package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import bancoDeDados.ConectaBD;

//Extends JFrame para referenciar a classe JFrame ao chamar as funções.
public class JPrincipal extends JFrame {
	private JFrame frame;
	private JTable tabelaProdutos;


	
		public JPrincipal(){
			JMenuBar menuBar;
			JMenu menu;
			JMenuItem menuItem;
			
			// Cria a barra de menu
			menuBar = new JMenuBar();
			
			// Constroi o menu
			menu = new JMenu("Novo Cadastro");
			menuBar.add(menu);
			
			menuItem = new JMenuItem("Cadastrar Produto");
			menu.add(menuItem);
			
			menuItem = new JMenuItem("Cadastrar Vendedor");
			menu.add(menuItem);
			
			// Cria conteudo do painel
		//	JPanel contentPane = new JPanel(new BorderLayout());
		//	contentPane.setOpaque(true);
			
			// Cria a janela
			JFrame frame = new JFrame("Lojix - Home");
			
			frame.setExtendedState(MAXIMIZED_BOTH); // Iniciar janela em tela cheia.
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			// Cria e arranja o conteúdo do painel
			frame.setJMenuBar(menuBar);
			
		
			String[] columnNames = {"Tipo",
                    "Tamanho",
                    "Valor",
                    "Quantidade",
                    };	
		
			ConectaBD bd = new ConectaBD();
			Object[][] dados = null; 
			dados =	bd.preencherTabelaProdutos();
			//ConectaBD.preencherTabelaProdutos(dados);
		
			for(int i = 0; i < 25; i++){
				System.out.print(dados[i][0] +" ");
				System.out.print(dados[i][1]+" ");
				System.out.print(dados[i][2]+" ");
				System.out.println(dados[i][3]+" ");
				}
			tabelaProdutos = new JTable(dados, columnNames);
			tabelaProdutos.setAutoResizeMode(tabelaProdutos.AUTO_RESIZE_OFF); 
			tabelaProdutos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		    tabelaProdutos.setPreferredScrollableViewportSize(new Dimension(500, 70));
		    tabelaProdutos.setFillsViewportHeight(true);
			
		     /*Adicionando tabela a uma barra de rolagem*/
			JScrollPane scrollpane =  new JScrollPane(tabelaProdutos); 
			
			tabelaProdutos.setFillsViewportHeight(true);
			
			/*Adicionando barra de rolagem ao painel*/
		//	contentPane.add(scrollpane);
			
			//getContentPane().add(contentPane);
			frame.add(tabelaProdutos.getTableHeader(), BorderLayout.PAGE_START);
			frame.add(tabelaProdutos, BorderLayout.CENTER);
			
			//frame.add(tabelaProdutos);
			frame.setVisible(true);
		}
}
