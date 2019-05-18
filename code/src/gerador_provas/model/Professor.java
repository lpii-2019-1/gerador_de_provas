package gerador_provas.model;

public class Professor {
    private long Cpf;
    private String nome;
    private String instituicao;
    private String email;
    private String senha;

 
    public Professor(long Cpf, String nome, String instituicao, String email, String senha) {
    	this.Cpf = Cpf;
    	this.nome = nome;
    	this.setInstituicao(instituicao);
    	this.email = email;
    	this.senha = senha;
    }
    
    public long getCpf() {
        return Cpf;
    }
    public void setCpf(Long Cpf) {
        this.Cpf = Cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}    
    
}
