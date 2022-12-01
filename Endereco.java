public class Endereco {
    private String logradouro, cidade, uf;
    private int numero;
    
    public void setEndereco(String logradouro, String cidade, String uf, int numero){
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.uf = uf;
        this.numero = numero;
    }

    public String getLogradouro(){
        return logradouro;
    }
    public String getCidade(){
        return cidade;
    }
    public String getUf(){
        return uf;
    }
    public int getNumero(){
        return numero;
    }
}


