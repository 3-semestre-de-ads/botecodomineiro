package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Abner Matias
 */
public class ProdutosNaComandaModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ProdutoNaComanda> dados = new ArrayList<>();// Linhas
	private String[] colunas = { "ID", "Produto", "Unidade", "Preço", "Quantidade", "Status" };// Cabeçalho
	private double precoTotal;

	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}

	@Override
	public int getRowCount() {
		return dados.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {

		switch (coluna) {
		case 0:
			return dados.get(linha).getID();
		case 1:
			return dados.get(linha).getProduto();
		case 2:
			return dados.get(linha).getUnidade();
		case 3:
			return dados.get(linha).getPreco();
		case 4:
			return dados.get(linha).getQuantidade();
		case 5:
			return dados.get(linha).getStatus();
		}

		return null;
	}

	// Adiciona Linha na tabela
	public double addRow(ProdutoNaComanda p) {
		boolean linhaExistente = false;
		int linha = 0;
		for (int x = 0; x < this.getRowCount(); x++) {
			if (this.getValueAt(x, 0).toString().equals(String.valueOf(p.getID()))) {
				linhaExistente = true;
				linha = x;
			}
		}

		if (linhaExistente) {
			this.updateRow(linha, p);
			precoTotal = precoTotal + p.getQuantidade() * p.getPreco();
		} else {
			this.dados.add(p);
			this.fireTableDataChanged();
			precoTotal = precoTotal + p.getQuantidade() * p.getPreco();
		}

		return precoTotal;
	}

	// Remove linha da tabela
	public double removeRow(int linha, ProdutoNaComanda p) {
		if (p.getQuantidade() == this.dados.get(linha).getQuantidade()) {
			this.dados.remove(linha);
			this.fireTableRowsDeleted(linha, linha);

			JOptionPane.showMessageDialog(null, "Produto removido");
			precoTotal = precoTotal - p.getQuantidade() * p.getPreco();
		} else {
			int qtd = this.dados.get(linha).getQuantidade();
			this.dados.get(linha).setQuantidade(qtd - p.getQuantidade());
			this.fireTableDataChanged();

			JOptionPane.showMessageDialog(null, "Quantidade removida");
			precoTotal = precoTotal - p.getQuantidade() * p.getPreco();
		}

		return precoTotal;
	}

	// Remove todas linhas da tabela
	public void removeAll() {
		this.dados.removeAll(dados);
		this.fireTableRowsDeleted(0, getRowCount());
	}

	// Atualiza qdt da linha na tabela
	public void updateRow(int linha, ProdutoNaComanda p) {
		int qtd = this.dados.get(linha).getQuantidade();

		this.dados.get(linha).setQuantidade(qtd + p.getQuantidade());
		this.fireTableDataChanged();

		JOptionPane.showMessageDialog(null, "Quantidade acrescentada");
	}
	
	// Atualiza status do produto na tabela
	public void updateRow(int linha, String status) {

		this.dados.get(linha).setStatus(status);
		this.fireTableDataChanged();

	}
	
}