package matsunoki.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JTextField;
import matsunoki.Produto;

public class BotaoNovoProdutoActionListener implements ActionListener {
	
	private JPanel panelFormularioProdutos;
	private JTextField codigoProdutoTextField;
	private JTextField descricaoProdutoTextField; 
	private JTextField precoProdutoTextField;

	public BotaoNovoProdutoActionListener(JPanel panelFormularioProdutos, JTextField codigoProdutoTextField,
			JTextField descricaoProdutoTextField, JTextField precoProdutoTextField){
		this.panelFormularioProdutos = panelFormularioProdutos;
		this.codigoProdutoTextField = codigoProdutoTextField;
		this.descricaoProdutoTextField = descricaoProdutoTextField;
		this.precoProdutoTextField = precoProdutoTextField;
                

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.panelFormularioProdutos.setVisible(true);
		this.codigoProdutoTextField.setText("");
		this.descricaoProdutoTextField.setText("");
		this.precoProdutoTextField.setText("");
	}

}
