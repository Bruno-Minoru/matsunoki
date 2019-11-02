package matsunoki;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

import javax.swing.JFrame;

import matsunoki.listener.MenuCadastroProdutoActionListener;

public class JanelaPrincipal extends JFrame {
	
	public JanelaPrincipal() {
		super("Floricultura Matsu No Ki"); // Mastu= pinho no= de(preposição) Ki = árvore/madeira
		setSize(1200, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void adicionaBarraDeMenu() {
		MenuBar menuBar = new MenuBar();

		adicionaMenuCadastro(menuBar);
		
		setMenuBar(menuBar);
		
	}
	
	private void adicionaMenuCadastro(MenuBar menuBar) {
		Menu menu = new Menu("Cadastros");
		
		MenuItem menuItemCadastroProduto = new MenuItem("Cadastro de Produtos");
		menuItemCadastroProduto.addActionListener(new MenuCadastroProdutoActionListener());
		
		menu.add(menuItemCadastroProduto);

		MenuItem menuItemCadastroCliente = new MenuItem("Cadastro de Clientes");
		menu.add(menuItemCadastroCliente);
		
		menuBar.add(menu);
	}
	
	
}
