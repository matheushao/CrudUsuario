package usuario.app.crudusuario;

/**
 * Created by Matheus Alves on 08/11/2016.
 */

public class Usuario {

    private int id;
    private String nome;
    private String senha;
    private String cpf;
    private String telefone;
    private String email;

    public Usuario(int id, String nome, String senha, String cpf, String telefone, String email){
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
    }

    public Usuario(String nome, String senha, String cpf, String telefone,String email){
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

