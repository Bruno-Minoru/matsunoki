package matsunoki;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import matsunoki.repositorio.ProdutoRepositorio;

public class Principal extends JFrame{
	public static JanelaPrincipal janelaPrincipal;
	
	public static void main(String[] args) {    
            carregaProdutos();
            janelaPrincipal = new JanelaPrincipal();
            janelaPrincipal.adicionaBarraDeMenu();
            janelaPrincipal.setVisible(true);
	}
	
	private static void carregaProdutos() {
		ProdutoRepositorio.salvarProduto(new Produto("Botão de Rosa", 3.5));
		ProdutoRepositorio.salvarProduto(new Produto("Dúzia de Botões de Rosa", 38.0));
		ProdutoRepositorio.salvarProduto(new Produto("Ciclamen", 15));
	}
       
    public static void abrir() {
        Principal frame = new Principal();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((tela.width - frame.getSize().width) / 2, (tela.height - frame.getSize().height) / 2);
        frame.setVisible(true);
    }    
}
