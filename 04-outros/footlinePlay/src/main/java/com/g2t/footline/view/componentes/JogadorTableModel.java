package com.g2t.footline.view.componentes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.g2t.footline.entisade.Jogador;
import com.g2t.footline.entisade.Posicao;

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
		
		//"P", "Nome", "Nível", "Salário", "Passe", "Gols", "CA", "CV" 
		jogador.setPosicao( aValue.getPosicao() );
		jogador.setNome(aValue.getNome());
		jogador.setNivel(aValue.getNivel());
		jogador.setSalario(aValue.getSalario());
		jogador.setValorPasse(aValue.getValorPasse());
		jogador.setQuantidadeGols(aValue.getQuantidadeGols());
		jogador.setCartaoAmarelo(aValue.getCartaoAmarelo());
		jogador.setCartaoVermelho(aValue.isCartaoVermelho());
		
		fireTableCellUpdated(rowIndex, 0);
		fireTableCellUpdated(rowIndex, 1);
		fireTableCellUpdated(rowIndex, 2);
		fireTableCellUpdated(rowIndex, 3);
		fireTableCellUpdated(rowIndex, 4);
		fireTableCellUpdated(rowIndex, 5);
		fireTableCellUpdated(rowIndex, 6);	
		fireTableCellUpdated(rowIndex, 7);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Jogador jogador = jogadores.get(rowIndex);

		switch (columnIndex) {
		case 0:
			jogador.setPosicao( Posicao.valueOf( aValue.toString() ) );
		case 1:
			jogador.setNome(aValue.toString());
		case 2:
			jogador.setNivel( Integer.parseInt(aValue.toString()) );
		case 3:
			jogador.setSalario( Float.parseFloat(aValue.toString()) );
		case 4:
			jogador.setValorPasse( Double.parseDouble(aValue.toString()) );
		case 5:
			jogador.setQuantidadeGols( Integer.parseInt( aValue.toString()) );
		case 6:
			jogador.setCartaoAmarelo( Integer.parseInt( aValue.toString()) );
		case 7:
			jogador.setCartaoVermelho( Boolean.parseBoolean( aValue.toString()) );
			
		default:
			System.err.println("indice da coluna invalido");
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Jogador jogadorSelecionado = jogadores.get(rowIndex);
		String valueObject = null;
		switch (columnIndex) {
		case 0:
			valueObject = jogadorSelecionado.getPosicao().name();
			break;
		case 1:
			valueObject = jogadorSelecionado.getNome();
			break;
		case 2:
			valueObject = String.valueOf( jogadorSelecionado.getNivel() );
			break;
		case 3:
			valueObject = String.valueOf( jogadorSelecionado.getSalario() );
			break;	
		case 4:
			valueObject = String.valueOf( jogadorSelecionado.getValorPasse() );
			break;
		case 5:
			valueObject = String.valueOf( jogadorSelecionado.getQuantidadeGols() );
			break;
		case 6:
			valueObject = String.valueOf( jogadorSelecionado.getCartaoAmarelo() );
			break;
		case 7:
			valueObject = String.valueOf( jogadorSelecionado.isCartaoVermelho() );
			break;			
		default:
			System.err.println("indice invalido para propriedade do bean Jogador.class");
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