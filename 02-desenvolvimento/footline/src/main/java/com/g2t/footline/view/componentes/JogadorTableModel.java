package com.g2t.footline.view.componentes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.g2t.footline.entity.Jogador;

public class JogadorTableModel extends AbstractTableModel {

	/**
	 * 7419763598897891865L
	 */
	private static final long serialVersionUID = 7419763598897891865L;
	
	private List<Jogador> jogadores;
	private String[] colunas = new String[] { 
		"P", "Nome", "Nível", "Salário", "Passe", "Gols", "CA", "CV" 
	};

	/** Creates a new instance of TableModel */
	public JogadorTableModel(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public JogadorTableModel() {
		this.jogadores = new ArrayList<Jogador>();
	}

	public int getRowCount() {
		return jogadores.size();
	}

	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public void setValueAt(Jogador aValue, int rowIndex) {
		Jogador jogador = jogadores.get(rowIndex);

		jogador.setPosicao(aValue.getPosicao());
		jogador.setNome(aValue.getNome());
		jogador.setPosicao(aValue.getPosicao());

		fireTableCellUpdated(rowIndex, 0);
		fireTableCellUpdated(rowIndex, 1);
		fireTableCellUpdated(rowIndex, 2);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Jogador jogador = jogadores.get(rowIndex);

		switch (columnIndex) {
		case 0:
			jogador.setPosicao(aValue.toString());
		case 1:
			jogador.setNome(aValue.toString());
		case 2:
			jogador.setNivel( Integer.parseInt( aValue.toString() ) );

		default:
			System.err.println("Índice da coluna inválido");
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Jogador jogadorSelecionado = jogadores.get(rowIndex);
		String valueObject = null;
		switch (columnIndex) {
		case 0:
			valueObject = jogadorSelecionado.getPosicao();
			break;
		case 1:
			valueObject = jogadorSelecionado.getNome();
			break;
		case 2:
			valueObject = String.valueOf( jogadorSelecionado.getNivel() );
			break;
		default:
			System.err.println("Índice inválido para propriedade do bean Jogador.class");
		}

		return valueObject;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public Jogador getJogador(int indiceLinha) {
		return jogadores.get(indiceLinha);
	}

	public void addJogador(Jogador jogador) {
		jogadores.add(jogador);

		int ultimoIndice = getRowCount() - 1;

		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}

	public void removeJogador(int indiceLinha) {
		jogadores.remove(indiceLinha);

		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}

	public void addListaDeJogadors(List<Jogador> novosJogadores) {

		int tamanhoAntigo = getRowCount();
		jogadores.addAll(novosJogadores);
		fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
	}

	public void limpar() {
		jogadores.clear();
		fireTableDataChanged();
	}

	public boolean isEmpty() {
		return jogadores.isEmpty();
	}

}