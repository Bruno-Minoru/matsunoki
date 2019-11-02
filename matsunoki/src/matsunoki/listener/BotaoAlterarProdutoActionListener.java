package matsunoki.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import matsunoki.Produto;

public class BotaoAlterarProdutoActionListener implements ActionListener {
	
	private JPanel panelFormularioProdutos;
	private JTable tabela;
	private JTextField codigoProdutoTextField;
	private JTextField descricaoProdutoTextField; 
	private JTextField precoProdutoTextField;

	public BotaoAlterarProdutoActionListener(JPanel panelFormularioProdutos, JTable tabela, JTextField codigoProdutoTextField,
			JTextField descricaoProdutoTextField, JTextField precoProdutoTextField) {
		this.panelFormularioProdutos = panelFormularioProdutos;
		this.codigoProdutoTextField = codigoProdutoTextField;
		this.descricaoProdutoTextField = descricaoProdutoTextField;
		this.precoProdutoTextField = precoProdutoTextField;
		this.tabela = tabela;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		int selectedRow = tabela.getSelectedRow();
		if(selectedRow < 0) {
			JOptionPane.showMessageDialog(null, "Nenhum produto foi selecionado");
		} else {
			Produto produto = ((ProdutosTableModel)tabela.getModel()).getProdutos().get(selectedRow);
			System.out.println(produto.getDescricao());
			codigoProdutoTextField.setText(String.valueOf(produto.getCodigoProduto()));
			descricaoProdutoTextField.setText(produto.getDescricao());
			precoProdutoTextField.setText(String.valueOf(produto.getPreco()));
			panelFormularioProdutos.setVisible(true);
		}
	}

}
