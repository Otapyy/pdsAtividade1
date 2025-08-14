package telas;

public class Usuario {
	
    private String nome;
    private String cpf;

//Construtor
    public Usuario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        
    }

//Getters    
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

}