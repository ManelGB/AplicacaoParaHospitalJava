package models;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Paciente {
    private static long numCNSClasse = 0;
    private long numCNS;
    private String nome, nomeMae, CPF;
    private Date dtnasc;
    private Sexo sexo;
    private PacienteComDef.tipo tipo;

    Endereco endereco = new Endereco();

    public void setPaciente(String nome, String nomeMae, String CPF, String dtnasc, char Sexo, String logradouro,
            String cidade, String uf, int numero) {

        this.nome = nome;
        this.nomeMae = nomeMae;
        this.CPF = CPF;
        this.numCNS = numCNSClasse;

        numCNSClasse++;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            this.dtnasc = sdf.parse(dtnasc);
        } catch (ParseException e) {

        }

        if (Sexo == 'm') {
            this.sexo = models.Sexo.MASCULINO;
        } else if (Sexo == 'f') {
            this.sexo = models.Sexo.FEMININO;
        } else {
            this.sexo = models.Sexo.OUTRO;
        }

        endereco.setEndereco(logradouro, cidade, uf, numero);
    }

    public void setAtualizaPaciente(String nome, String nomeMae, String dtnasc, char Sexo, String logradouro,
            String cidade, String uf, int numero) {

        this.nome = nome;
        this.nomeMae = nomeMae;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            this.dtnasc = sdf.parse(dtnasc);
        } catch (ParseException e) {

        }

        if (Sexo == 'm') {
            this.sexo = models.Sexo.MASCULINO;
        } else if (Sexo == 'f') {
            this.sexo = models.Sexo.FEMININO;
        } else {
            this.sexo = models.Sexo.OUTRO;
        }

        endereco.setEndereco(logradouro, cidade, uf, numero);
    }

    public String getNome() {
        return nome;
    }

    public String getDtNasc() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String datanasc = sdf.format(dtnasc);
        return datanasc;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public String getCPF() {
        return CPF;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public long getCNS() {
        return numCNS;
    }
}
