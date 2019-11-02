package matsunoki.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import matsunoki.Principal;
import matsunoki.Produto;
import matsunoki.repositorio.ProdutoRepositorio;

public class BotaoSalvarProdutoActionListener implements ActionListener {
	private ProdutosTableModel produtoTableModel;
	private JPanel panelFormularioProdutos;
	private JTextField codigoProdutoTextField;
	private JTextField descricaoProdutoTextField; 
	private JTextField precoProdutoTextField;

	public BotaoSalvarProdutoActionListener(ProdutosTableModel produtoTableModel, JPanel panelFormularioProdutos,
			JTextField codigoProdutoTextField, JTextField descricaoProdutoTextField, JTextField precoProdutoTextField) {
		this.produtoTableModel = produtoTableModel;
		this.panelFormularioProdutos = panelFormularioProdutos;
		this.codigoProdutoTextField = codigoProdutoTextField;
		this.descricaoProdutoTextField = descricaoProdutoTextField;
		this.precoProdutoTextField = precoProdutoTextField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Produto produto = new Produto();
		boolean dadosValidos = true;
		if(this.codigoProdutoTextField.getText() != null && !this.codigoProdutoTextField.getText().trim().equals("")) {
			try {
				produto.setCodigoProduto(Integer.parseInt(this.codigoProdutoTextField.getText()));
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(Principal.janelaPrincipal, "Código do produto inválido");
				dadosValidos = false;
			}
		}
		if(this.descricaoProdutoTextField.getText() != null && !this.descricaoProdutoTextField.getText().trim().equals("")) {
			produto.setDescricao(this.descricaoProdutoTextField.getText());
		} else {
			JOptionPane.showMessageDialog(Principal.janelaPrincipal, "A descrição é inválida");
			dadosValidos = false;
		}

		if(this.precoProdutoTextField.getText() != null && !this.precoProdutoTextField.getText().trim().equals("")) {
			try {
				produto.setPreco(Double.parseDouble(this.precoProdutoTextField.getText()));
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(Principal.janelaPrincipal, "Preço do produto inválido");
				dadosValidos = false;
			}
		}
		if(dadosValidos) {
			ProdutoRepositorio.salvarProduto(produto);

//			this.codigoProdutoTextField.setText("");
//			this.descricaoProdutoTextField.setText("");
//			this.precoProdutoTextField.setText("");
//			this.panelFormularioProdutos.setVisible(false);                                           
//                      produto.setCodigoProduto(Integer.parseInt(codigoProdutoTextField.getText()));
                        produto.setDescricao(descricaoProdutoTextField.getText());
                        produto.setPreco(Double.parseDouble(precoProdutoTextField.getText()));
                        ProdutDAO dao = new ProdutDAO();
                        
                        dao.salvar(produto);
			produtoTableModel.fireTableDataChanged();
			Principal.janelaPrincipal.invalidate();
			Principal.janelaPrincipal.validate();
			Principal.janelaPrincipal.repaint();
			JOptionPane.showMessageDialog(Principal.janelaPrincipal, "Produto Cadastrado com sucesso");
		}
	}

}
