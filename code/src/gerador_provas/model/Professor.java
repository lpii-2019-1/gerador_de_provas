package gerador_provas.model;

public class Professor {
    private int Cpf;
    private String nome;
    private String email;
    private String senha;

 
    public int getCpf() {
        return Cpf;
    }
    public void setCpf(int Cpf) {
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
    
}
