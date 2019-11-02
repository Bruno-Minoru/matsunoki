package matsunoki.repositorio;

import java.util.ArrayList;
import java.util.List;

import matsunoki.Produto;

public class ProdutoRepositorio {
	
	private static int codigoProduto = 1;
	private static List<Produto> produtos = new ArrayList<>();
	
	public static List<Produto> obterTodosProdutos() {
		return produtos;
	}
	
	//Salva o produto
	public static int salvarProduto(Produto produto) {
		//Verifica se o produto já existe na tabela
		Produto produtoCadastradoNaBase = obterProdutoPorCodigo(produto.getCodigoProduto());
		// Se não existir
		if(produtoCadastradoNaBase == null) {
			// Atribui um código
			produto.setCodigoProduto(codigoProduto);
			// Incrementa o código do produto
			codigoProduto++; 
			//Adiciona na tabela
			produtos.add(produto);
		} else { //Se existir
			//altera a descrição do que ele achou na tabela
			produtoCadastradoNaBase.setDescricao(produto.getDescricao());

			//altera o preço do que ele achou na tabela
			produtoCadastradoNaBase.setPreco(produto.getPreco());
			
			// Obtem a posição do produto na tabela
			int indiceDoProdutoNaLista = produtos.indexOf(produtoCadastradoNaBase);
			
			// Altera o produto da tabela
			produtos.set(indiceDoProdutoNaLista, produtoCadastradoNaBase);
		}
		return codigoProduto;
	}
	
	// Obtem o produto pelo código dele
	public static Produto obterProdutoPorCodigo(int codigoProduto) {
		
		// Itera sobre a tabela de produtos
		for(Produto produto : produtos) {
			//Verifica se o código do produto da tabela é igual ao código informado
			if(produto.getCodigoProduto() == codigoProduto) {
				//Se forem iguais, retorna ele
				return produto;
			}
		}
		
		//Se chegou até aqui é porque não encontrou nenhum produto cadastrado com o mesmo código
		return null;
	}
	
	public static void excluirProduto(Produto produto) {
		Produto produtoCadastradoNaBase = obterProdutoPorCodigo(produto.getCodigoProduto());
		if(produtoCadastradoNaBase != null) {
			produtos.remove(produtoCadastradoNaBase);
		}
	}

}
