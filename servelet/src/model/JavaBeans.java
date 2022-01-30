package model;

public class JavaBeans {
	private String idProd;
	private String nome;
	private String quantidade;
	private String tipo;
	
	public JavaBeans() {
		super();
	}
	
	public JavaBeans(String idProd, String nome, String quantidade, String tipo) {
		super();
		this.idProd = idProd;
		this.nome = nome;
		this.quantidade = quantidade;
		this.tipo = tipo;
	}

	public String getIdProd() {
		return idProd;
	}
	public void setIdProd(String idProd) {
		this.idProd = idProd;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}	
	
	

}