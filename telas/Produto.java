package telas;

public class Produto {
	
    private String nome;
    private String valor;
    private Boolean noCarrinho;



//Construtor
    public Produto(String nome, String valor) {
        this.nome = nome;
        this.valor = valor;
        this.noCarrinho = false;

    }

//Getters    
    public String getNome() {
        return nome;
    }

    public String getValor() {
        return valor;
    }

}