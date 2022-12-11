package models;

public class Usuario {
private static long idClasse = 0;
private long id;
private String nome, nomeLogin, senha;
private Tipo tipo;

public void setUsuario(String nome, String nomeLogin, String senha, char tipo ){
    this.nome = nome;
    this.nomeLogin = nomeLogin;
    this.senha = senha;
    this.id = idClasse;

    idClasse ++;
    
    if(tipo=='a'){
        this.tipo = Tipo.ATENDENTE;
    }else{
        this.tipo = Tipo.MÉDICO;
    }
}

public void setAtualizarUsuario(String nome, String nomeLogin, String senha, char tipo ){
    this.nome = nome;
    this.nomeLogin = nomeLogin;
    this.senha = senha;
    if(tipo=='a'){
        this.tipo = Tipo.ATENDENTE;
    }else{
        this.tipo = Tipo.MÉDICO;
    }
}
public String getNome() {
    return nome;
}

public String getNomeLogin() {
    return nomeLogin;
}

public String getSenha() {
    return senha;
}

public Tipo getTipo() {
    return tipo;
}

public long getId() {
    return id;
}

public long getIdClasse() {
    return idClasse;
}

}
