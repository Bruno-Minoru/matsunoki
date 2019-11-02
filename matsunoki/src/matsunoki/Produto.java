package matsunoki;

public class Produto {
	private int codigoProduto;
	private String descricao;
	private double preco;
	

	public Produto(int codigoProduto, String descricao, double preco) {
		super();
		this.codigoProduto = codigoProduto;
		this.descricao = descricao;
		this.preco = preco;
	}

	public Produto(String descricao, double preco) {
		super();
		this.descricao = descricao;
		this.preco = preco;
	}

	public Produto() {
		super();
	}

	public int getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
