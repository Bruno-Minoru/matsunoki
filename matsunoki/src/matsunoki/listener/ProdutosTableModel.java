package matsunoki.listener;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import matsunoki.Produto;
import matsunoki.repositorio.ProdutoRepositorio;

public class ProdutosTableModel extends AbstractTableModel {
	
	private List<Produto> produtos;
	private String[] columnNames;
	
	public ProdutosTableModel(List<Produto> produtos, String[] columnNames) {
		super();
		this.produtos = produtos;
		this.columnNames = columnNames;
	}

	@Override
	public int getRowCount() {
		return produtos.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}
	
	@Override
	public void fireTableDataChanged() {// método que dispara as alterações da tabela e consolida na tela
		produtos = ProdutoRepositorio.obterTodosProdutos();
		super.fireTableDataChanged();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		System.out.println("rowIndex: " + rowIndex + ", columnIndex: " + columnIndex);
		switch (columnIndex) {
		case 0:
			return produtos.get(rowIndex).getCodigoProduto();
		case 1:
			return produtos.get(rowIndex).getDescricao();
		case 2:
			return produtos.get(rowIndex).getPreco();
		default:
			break;
		}
		return null;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}

