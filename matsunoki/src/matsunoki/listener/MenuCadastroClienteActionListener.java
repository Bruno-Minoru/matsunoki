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

public class MenuCadastroClienteActionListener implements ActionListener {
	

	public MenuCadastroClienteActionListener() {
		super();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Principal.janelaPrincipal.setTitle("Floricultura Matsu No Ki - Cadastro de Clientes");
	
		JPanel panelCadastroClientes = new JPanel(new GridLayout(2, 1));
		JPanel panelListagemClientes = new JPanel();
		panelListagemClientes.setLayout(null);
		panelCadastroClientes.add(panelListagemClientes);
		
		// Cria o painal com o formulario de cadastro de clientes
		JPanel panelFormularioClientes = new JPanel();
		panelFormularioClientes.setLayout(null);
		panelFormularioClientes.setBorder(new LineBorder(Color.BLUE));
		panelFormularioClientes.setVisible(false);
		panelCadastroClientes.add(panelFormularioClientes);
		
		// Label do código
		JLabel codigoClientelLabel = new JLabel("Código do Cliente:  ");
		codigoClientelLabel.setHorizontalAlignment(JLabel.RIGHT); // Alinha o texto à direita
		codigoClientelLabel.setBounds(5, 30, 450, 15); // Define a posição x/y e o tamanho largura/altura, nessa ordem
		panelFormularioClientes.add(codigoClientelLabel); //adiciona ao painel de formulário de cadastro
		
		// Campo de texto
		JTextField codigoClienteTextField = new JTextField();
		codigoClienteTextField.setBounds(460, 26, 300, 20);// Define a posição x/y e o tamanho largura/altura, nessa ordem
		codigoClienteTextField.setEditable(false);// Não pode alterar, o sistema tem que designar um código
		panelFormularioClientes.add(codigoClienteTextField);//adiciona ao painel de formulário de cadastro
		
		JLabel nomeClienteLabel = new JLabel("Nome Completo:  ");
		nomeClienteLabel.setHorizontalAlignment(JLabel.RIGHT);
		nomeClienteLabel.setBounds(5, 60, 450, 15);
		panelFormularioClientes.add(nomeClienteLabel);
		
		JTextField descricaoClienteTextField = new JTextField();
		descricaoClienteTextField.setBounds(460, 56, 300, 20);
		panelFormularioClientes.add(descricaoClienteTextField);
		
		JLabel precoClientelLabel = new JLabel("Preço do Produto:  ");
		precoClientelLabel.setHorizontalAlignment(JLabel.RIGHT);
		precoClientelLabel.setBounds(5, 86, 450, 15);
		panelFormularioClientes.add(precoClientelLabel);
		
		JTextField precoClienteTextField = new JTextField();
		precoClienteTextField.setBounds(460, 82, 300, 20);
		panelFormularioClientes.add(precoClienteTextField);

		

		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(new BotaoCancelarProdutoActionListener(panelFormularioClientes, codigoClienteTextField, descricaoClienteTextField, precoClienteTextField));
		buttonCancelar.setBounds(590, 120, 100, 20);
		panelFormularioClientes.add(buttonCancelar);
		

		JButton buttonNovoCliente = new JButton("Novo Produto");
		buttonNovoCliente.addActionListener(new BotaoNovoProdutoActionListener(panelFormularioClientes, codigoClienteTextField, descricaoClienteTextField, precoClienteTextField));
		buttonNovoCliente.setBounds(1035, 245, 150, 20);
		panelListagemClientes.add(buttonNovoCliente);
		
		// Para exibir a tabela de clientes, é necessário utilizar o painel com scroll
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(8, 8, 1180, 230);
		
		// Tabela de listagem de produtos
		ProdutosTableModel produtoTableModel = preencherProdutoTableModel();
		JTable listagemProdutos = new JTable(produtoTableModel);
		listagemProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Define o tipo de seleção para apenas um registro por vez
		scrollPane.setViewportView(listagemProdutos);
		panelListagemClientes.add(scrollPane);

		// Botão Salvar
		JButton botaoSalvar = new JButton("Salvar");
		// Adiciona um processador de ação (clique) no botão
		botaoSalvar.addActionListener(new BotaoSalvarProdutoActionListener(produtoTableModel, panelFormularioClientes, codigoClienteTextField, descricaoClienteTextField, precoClienteTextField));
		botaoSalvar.setBounds(460, 120, 100, 20);
		panelFormularioClientes.add(botaoSalvar);

		JButton buttonAlterarProduto = new JButton("Alterar Produto");
		buttonAlterarProduto.addActionListener(new BotaoAlterarProdutoActionListener(panelFormularioClientes, listagemProdutos,
				codigoClienteTextField, descricaoClienteTextField, precoClienteTextField));
		buttonAlterarProduto.setBounds(835, 245, 150, 20);
		panelListagemClientes.add(buttonAlterarProduto);

		JButton buttonExcluirProduto = new JButton("Excluir Produto");
		buttonExcluirProduto.addActionListener(new BotaoExcluirProdutoActionListener(produtoTableModel, listagemProdutos,
				codigoClienteTextField, descricaoClienteTextField, precoClienteTextField));
				buttonExcluirProduto.setBounds(635, 245, 150, 20);
		panelListagemClientes.add(buttonExcluirProduto);
		
		
		
		Principal.janelaPrincipal.add(panelCadastroClientes);
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
