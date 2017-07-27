package gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModeloTabelaProduto extends AbstractTableModel {
	private String[] colunas;
	private ArrayList linhas;
	


	public ModeloTabelaProduto(ArrayList lin, String[] colunas) {
		setLinhas(lin);
		setColunas(colunas);
		
	}
	

	public String[] getColunas() {
		return colunas;
	}

	public void setColunas(String[] colunas) {
		this.colunas = colunas;
	}

	public ArrayList getLinhas() {
		return linhas;
	}


	public void setLinhas(ArrayList linhas) {
		this.linhas = linhas;
	}


	public int getColumnCount() {
		return colunas.length;
	}

	public int getRowCount() {
		return linhas.size();
	}

	public String getColumnName(int col) {
		return colunas[col];
	}

	public Object getValueAt(int col) {
		return colunas[col];
	}

	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}



	@Override
	public Object getValueAt(int numLin, int numCol) {
		Object[] linha = (Object[])getLinhas().get(numLin);
		return linha[numCol];
	}

}
