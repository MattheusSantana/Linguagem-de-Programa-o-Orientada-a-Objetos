package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import bancoDeDados.ConectaBD;
import entidades.TAMANHO;
import entidades.TIPO;

public class JProduto extends JFrame implements ActionListener{
	private JLabel tipo;
	private JLabel tamanho;
	private JLabel valor;
	private JLabel quantidade;
	private JButton cadastrar;
	private JButton cancelar;	
	private JTextField v;
	private JTextField qtd;
	private JComboBox<String> t = new JComboBox<String>();
	private JComboBox<String> tam = new JComboBox<String>();
	
	JFrame frame = new JFrame();
	ConectaBD bd = new ConectaBD();
	
	public JProduto (){
		
		setLayout(null);
		setTitle("Lojix  -  Cadastrar Produto");
		
		
			JLabel titulo = new JLabel("Cadastrar Produto");
			titulo.setBounds(100, 30, 150, 20);
			
			
			tipo = new JLabel("Tipo:");
			tipo.setBounds(100, 70, 150, 20);
		
			t.addItem(TIPO.CALCA_F.toString());
			t.addItem(TIPO.CALCA_M.toString());
			t.addItem(TIPO.CAMISETA_F.toString());
			t.addItem(TIPO.CAMISETA_M.toString());
			t.addItem(TIPO.JAQUETA_F.toString());
			t.addItem(TIPO.JAQUETA_M.toString());
			t.addItem(TIPO.SHORT_F.toString());
			t.addItem(TIPO.SHORT_M.toString());
			t.setBounds(100, 90, 150, 20);
			
			tamanho = new JLabel("Tamanho:");
			tamanho.setBounds(100, 170, 150, 20);
			
			tam.addItem(TAMANHO.TAM_P.toString());
			tam.addItem(TAMANHO.TAM_M.toString());
			tam.addItem(TAMANHO.TAM_G.toString());
			tam.addItem(TAMANHO.TAM_GG.toString());
			tam.addItem(TAMANHO.TAM_EXTRA_G.toString());
			tam.setBounds(100, 190, 200, 20);
			
		
		
			
			
			valor = new JLabel("Valor:");
			valor.setBounds(100, 270, 200, 20);
			
			v = new JTextField(30);
			v.setBounds(100, 290, 200, 20);
			
			quantidade = new JLabel("Quantidade:");
			quantidade.setBounds(100, 370, 200, 20);

			qtd = new JTextField(30);
			qtd.setBounds(100, 390, 200, 20);
			
			cadastrar = new JButton("Cadastrar");
			cadastrar.setBounds(100, 470, 200, 40);
			cadastrar.addActionListener(this);
			cancelar = new JButton("Cancelar");
			cancelar.setBounds(300, 470, 200, 40);
			cancelar.addActionListener(this);
			
			add(titulo);
			add(tipo);
			add(t);
			add(tamanho);
			add(tam);
			add(valor);
			add(v);
			add(quantidade);
			add(qtd);
			add(cadastrar);
			add(cancelar);
			
			setSize(600,800);
			setVisible(true);
			
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cadastrar){
			if(!(v.getText().matches("[0-9]+") || qtd.getText().matches("[0-9]+"))) {
				JOptionPane.showMessageDialog(null, "Preencha os campos corretamente!");
				return;
		}else{
				/*TENTE FAZER O CADASTRO!*/
				/*LANÇAR EXCEÇÕES AQUI E MOSTRAR MENSAGEM DE ERRO AO USUARIO INFORMANDO QUE NAO FOI POSSIVEL.*/
				int resultado = bd.cadastrarProduto(Double.parseDouble(v.getText()), Integer.parseInt(qtd.getText()), tam.getSelectedItem().toString(), t.getSelectedItem().toString());
				if(resultado == 1)
					JOptionPane.showMessageDialog(null, "Produto Cadastrado!");
				else if(resultado == 0)
					JOptionPane.showMessageDialog(null, "Produto ja Cadastrado!");	
				else
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar Produto!");
			}
			
	}
		if(e.getSource()== cancelar){
			System.exit(0);
		}
	}
	
	
}
