package matsunoki.listener;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;

import matsunoki.Principal;
import matsunoki.Produto;
import matsunoki.repositorio.ProdutoRepositorio;

public class MenuCadastroProdutoActionListener implements ActionListener {
	

	public MenuCadastroProdutoActionListener() {
		super();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Principal.janelaPrincipal.setTitle("Floricultura Matsu No Ki - Cadastro de Produtos");
	
		JPanel panelCadastroProdutos = new JPanel(new GridLayout(2, 1));
		JPanel panelListagemProdutos = new JPanel();
		panelListagemProdutos.setLayout(null);
		panelCadastroProdutos.add(panelListagemProdutos);
		
		// Cria o painal com o formulario de cadastro de produtos
		JPanel panelFormularioProdutos = new JPanel();
		panelFormularioProdutos.setLayout(null);
		panelFormularioProdutos.setBorder(new LineBorder(Color.BLUE));
		panelFormularioProdutos.setVisible(false);
		panelCadastroProdutos.add(panelFormularioProdutos);
		
		// Label do código
		JLabel codigoProdutolLabel = new JLabel("Código do Produto:  ");
		codigoProdutolLabel.setHorizontalAlignment(JLabel.RIGHT); // Alinha o texto à direita
		codigoProdutolLabel.setBounds(5, 30, 450, 15); // Define a posição x/y e o tamanho largura/altura, nessa ordem
		panelFormularioProdutos.add(codigoProdutolLabel); //adiciona ao painel de formulário de cadastro
		
		// Campo de texto
		JTextField codigoProdutoTextField = new JTextField();
		codigoProdutoTextField.setBounds(460, 26, 300, 20);// Define a posição x/y e o tamanho largura/altura, nessa ordem
		codigoProdutoTextField.setEditable(false);// Não pode alterar, o sistema tem que designar um código
		panelFormularioProdutos.add(codigoProdutoTextField);//adiciona ao painel de formulário de cadastro
		
		JLabel descricaoProdutoLabel = new JLabel("Descrição do Produto:  ");
		descricaoProdutoLabel.setHorizontalAlignment(JLabel.RIGHT);
		descricaoProdutoLabel.setBounds(5, 60, 450, 15);
		panelFormularioProdutos.add(descricaoProdutoLabel);
		
		JTextField descricaoProdutoTextField = new JTextField();
		descricaoProdutoTextField.setBounds(460, 56, 300, 20);
		panelFormularioProdutos.add(descricaoProdutoTextField);
		
		JLabel precoProdutolLabel = new JLabel("Preço do Produto:  ");
		precoProdutolLabel.setHorizontalAlignment(JLabel.RIGHT);
		precoProdutolLabel.setBounds(5, 86, 450, 15);
		panelFormularioProdutos.add(precoProdutolLabel);
		
		JTextField precoProdutoTextField = new JTextField();
		precoProdutoTextField.setBounds(460, 82, 300, 20);
		panelFormularioProdutos.add(precoProdutoTextField);

		

		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(new BotaoCancelarProdutoActionListener(panelFormularioProdutos, codigoProdutoTextField, descricaoProdutoTextField, precoProdutoTextField));
		buttonCancelar.setBounds(590, 120, 100, 20);
		panelFormularioProdutos.add(buttonCancelar);
		

		JButton buttonNovoProduto = new JButton("Novo Produto");
		buttonNovoProduto.addActionListener(new BotaoNovoProdutoActionListener(panelFormularioProdutos, codigoProdutoTextField, descricaoProdutoTextField, precoProdutoTextField));
		buttonNovoProduto.setBounds(1035, 245, 150, 20);
		panelListagemProdutos.add(buttonNovoProduto);
		
		// Para exibir a tabela de produtos, � necess�rio utilizar o painel com scroll
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(8, 8, 1180, 230);
		
		// Tabela de listagem de produtos
		ProdutosTableModel produtoTableModel = preencherProdutoTableModel();
		JTable listagemProdutos = new JTable(produtoTableModel);
		listagemProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Define o tipo de sele��o para apenas um registro por vez
		scrollPane.setViewportView(listagemProdutos);
		panelListagemProdutos.add(scrollPane);

		// Bot�o Salvar
		JButton botaoSalvar = new JButton("Salvar");
		// Adiciona um processador de a��o (clique) no bot�o
		botaoSalvar.addActionListener(new BotaoSalvarProdutoActionListener(produtoTableModel, panelFormularioProdutos, codigoProdutoTextField, descricaoProdutoTextField, precoProdutoTextField));
		botaoSalvar.setBounds(460, 120, 100, 20);
		panelFormularioProdutos.add(botaoSalvar);

		JButton buttonAlterarProduto = new JButton("Alterar Produto");
		buttonAlterarProduto.addActionListener(new BotaoAlterarProdutoActionListener(panelFormularioProdutos, listagemProdutos,
				codigoProdutoTextField, descricaoProdutoTextField, precoProdutoTextField));
		buttonAlterarProduto.setBounds(835, 245, 150, 20);
		panelListagemProdutos.add(buttonAlterarProduto);

		JButton buttonExcluirProduto = new JButton("Excluir Produto");
		buttonExcluirProduto.addActionListener(new BotaoExcluirProdutoActionListener(produtoTableModel, listagemProdutos,
				codigoProdutoTextField, descricaoProdutoTextField, precoProdutoTextField));
				buttonExcluirProduto.setBounds(635, 245, 150, 20);
		panelListagemProdutos.add(buttonExcluirProduto);
		
		
		
		Principal.janelaPrincipal.add(panelCadastroProdutos);
		Principal.janelaPrincipal.invalidate();
		Principal.janelaPrincipal.validate();
		Principal.janelaPrincipal.repaint();
	}

	// Preenche a tabela de listagem de produtos
	private ProdutosTableModel preencherProdutoTableModel() {
		List<Produto> produtos = ProdutoRepositorio.obterTodosProdutos();
		return new ProdutosTableModel(produtos, new String[] {"Código do Produto", "Descrição do Produto", "Preço do Produto"});
	}

}
