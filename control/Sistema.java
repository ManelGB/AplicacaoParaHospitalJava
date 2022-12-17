package control;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import view.padraoView;
import models.Anamnese;
import models.Paciente;
import models.Sexo;
import models.Tipo;
import models.Usuario;
import models.Validacao;

public class Sistema {

    Scanner sc = new Scanner(System.in);

    Validacao validacao = new Validacao();

    Paciente pacientesA[] = new Paciente[30];
    Anamnese anamnesesA[] = new Anamnese[30];
    Usuario usuariosA[] = new Usuario[30];

    /*---------------------------------------------------- Sistema ----------------------------------------------------------*/

    public boolean autenticar(String login, String senha, List<Usuario> usuarios) {
        return validacao.validaUsuario(login, senha, usuarios);
    }

    public String getNome(String login, String senha, List<Usuario> usuarios) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (login.equals(usuarios.get(i).getNomeLogin()) && senha.equals(usuarios.get(i).getSenha())) {
                return usuarios.get(i).getNome();
            }
        }
        return null;
    }

    public void init(List<Paciente> pacientes, List<Anamnese> anamneses, List<Usuario> usuarios) {

        for (int i = 0; i < 30; i++) {
            pacientesA[i] = new Paciente();
            usuariosA[i] = new Usuario();
            anamnesesA[i] = new Anamnese();
        }

        pacientesA[0].setPaciente("Emanuel Gon", "Josefina da Silva", "52264982098", "20/02/2004", 'm',
                "Rua dos Bobo", "Ipatinga", "MG", 123);
        pacientesA[1].setPaciente("TATÁ Bacanudo", "Elis Condoisélle", "12345678912", "01/02/2004", 'o',
                "Avenida Brasil", "Timóteo", "MG", 159);
        pacientesA[2].setPaciente("Lidiane Morais", "Rosalina Condoisélle", "98745632198", "01/02/1960", 'f',
                "Avenida Macapá", "Santos", "SP", 147);
        pacientes.add(pacientesA[0]);
        pacientes.add(pacientesA[1]);
        pacientes.add(pacientesA[2]);

        usuariosA[0].setUsuario("Emanuel", "Emanuel", "123456789", 'a');
        usuariosA[1].setUsuario("Tatá", "Thalles", "987654321", 'm');
        usuariosA[2].setUsuario("Lidiane Morais", "Rosalina Condoisélle", "123qwe", 'a');
        usuarios.add(usuariosA[0]);
        usuarios.add(usuariosA[1]);
        usuarios.add(usuariosA[2]);

        anamnesesA[0].setAnamnese("Emanuel", "dor de carregar o peso de ser um tremendo feioso", "Dor de cabeça",
                pacientes.get(0));
        anamnesesA[1].setAnamnese("TATÁ", "dor de carregar o peso de ser um tremendo gostoso", "Dor no olho",
                pacientes.get(1));
        anamnesesA[2].setAnamnese("Lidiane", "Programadora", "Dor lombar",
                pacientes.get(2));

        anamneses.add(anamnesesA[0]);
        anamneses.add(anamnesesA[1]);
        anamneses.add(anamnesesA[2]);

    }

    public Tipo tipoUsuario(String login, String senha, List<Usuario> usuarios) {

        for (int i = 0; i < usuarios.size(); i++) {
            if (login.equals(usuarios.get(i).getNomeLogin()) && senha.equals(usuarios.get(i).getSenha())) {
                Tipo tipo = usuarios.get(i).getTipo();
                return tipo;
            }
        }
        return null;
    }

    /*----------------------------------------------------------------------------------------------------------------------*/

    /*---------------------------------------------------- Paciente ----------------------------------------------------------*/

    public void atualizarPaciente(List<Paciente> pacientes) {

        System.out.println("Insira o CPF do usuário que você deseja mudar:");
        String CPF = sc.next();
        System.out.println();

        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i) != null && pacientes.get(i).getCPF() != null) {
                if (pacientes.get(i).getCPF().equals(CPF)) {
                    System.out.println("Insira o nome do paciente:");
                    String nome = sc.next();
                    nome += sc.nextLine();
                    System.out.println();

                    System.out.println("Insira nome da Mãe do paciente:");
                    String nomeMae = sc.next();
                    nomeMae += sc.nextLine();
                    System.out.println();

                    System.out.println("Insira a data de nascimento do cliente,utilizando do modelo" +
                            " dd/mm/aaaa ( é necessário colocar a barra )");
                    String datanasc = sc.next();
                    System.out.println();

                    System.out.println("Insira o sexo do paciente ( m - masculino, f - feminino, o -" +
                            " outro )");
                    char sexo = sc.next().toLowerCase().charAt(0);
                    System.out.println();

                    System.out.println("Insira o logradouro do paciente: ");
                    String logradouro = sc.next();
                    logradouro += sc.nextLine();
                    System.out.println();

                    System.out.println("Insira a cidade do paciente: ");
                    String cidade = sc.next();
                    cidade += sc.nextLine();
                    System.out.println();

                    System.out.println("Insira a sigla do estado do paciente: ");
                    String uf = sc.next();
                    System.out.println();

                    System.out.println("Insira o número da residência do paciente: ");
                    int numero = sc.nextInt();
                    System.out.println();

                    pacientes.get(i).setAtualizaPaciente(nome, nomeMae, datanasc, sexo, logradouro, cidade, uf, numero);
                }
            }
        }
    }

    public boolean criarPaciente(List<Paciente> pacientes) {

        String CPF = receberCPF();
        if (validacao.validaCPF(CPF)) {
            if (validacao.validaCPF(CPF, pacientes)) {
                inserirDadosPaciente(CPF, pacientes);

            } else {
                while (!validacao.validaCPF(CPF)) {
                    System.out.println("\nErro com o CPF inserido, por favor tente novamente!");
                    CPF = receberCPF();
                }
                inserirDadosPaciente(CPF, pacientes);
            }
        } else {
            while (!validacao.validaCPF(CPF)) {
                System.out.println("\nInsira somente números");
                CPF = receberCPF();
            }
            if (validacao.validaCPF(CPF, pacientes)) {
                inserirDadosPaciente(CPF, pacientes);

            } else {
                while (!validacao.validaCPF(CPF, pacientes)) {
                    System.out.println("\nErro com o CPF inserido, por favor tente novamente!");
                    CPF = receberCPF();
                }
                inserirDadosPaciente(CPF, pacientes);
            }
        }

        return true;
    }

    public boolean excluirPaciente(String CPF, List<Paciente> pacientes, List<Anamnese> anamneses) {
        validacao.validaCPF(CPF);
        validacao.validaCPF(CPF, pacientes);
        int idExcluir = -1;
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i) != null && pacientes.get(i).getNome() != null) {
                if (pacientes.get(i).getCPF().equals(CPF)) {
                    idExcluir = i;
                }
            }
        }

        if (idExcluir < 0) {
            System.out.println("\nO CPF não foi encontrado! \n");
            return false;
        }

        for (int i = 0; i < anamneses.size(); i++) {
            if (anamneses.get(i).getMotivo() != null) {

                if (anamneses.get(i).getPaciente().getCPF().equals(pacientes.get(idExcluir).getCPF())) {
                    System.out.println("Não é possível excluir este paciente, pois o mesmo tem anamneses");
                    return false;
                }
            }
        }
        pacientes.remove(idExcluir);
        System.out.println("Paciente excluído\n");
        return true;
    }

    public void inserirDadosPaciente(String CPF, List<Paciente> pacientes) {

        System.out.println("Insira o nome do paciente:");
        String nome = sc.next();
        nome += sc.nextLine();
        System.out.println();

        System.out.println("Insira nome da Mãe do paciente:");
        String nomeMae = sc.next();
        nomeMae += sc.nextLine();
        System.out.println();

        System.out.println("Insira a data de nascimento do cliente, utilizando do modelo" +
                " dd/mm/aaaa ( é necessário colocar a barra )");
        String datanasc = sc.next();
        System.out.println();

        System.out.println("Insira o sexo do paciente ( m - masculino, f - feminino, o -" +
                " outro )");
        char sexo = sc.next().toLowerCase().charAt(0);
        System.out.println();

        System.out.println("Insira o logradouro do paciente: ");
        String logradouro = sc.next();
        logradouro += sc.nextLine();
        System.out.println();

        System.out.println("Insira a cidade do paciente: ");
        String cidade = sc.next();
        cidade += sc.nextLine();
        System.out.println();

        System.out.println("Insira a sigla do estado do paciente: ");
        String uf = sc.next();
        System.out.println();

        System.out.println("Insira o número da residência do paciente: ");
        int numero = sc.nextInt();
        System.out.println();

        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println(pacientes.get(i).getCPF());
            Paciente newP = new Paciente();
            newP.setPaciente(nome, nomeMae, CPF, datanasc, sexo, logradouro, cidade, uf, numero);

            pacientes.add(newP);

            System.out.println("Paciente cadastrado com sucesso\n");
            break;
        }
    }

    public void listarPacientes(List<Paciente> pacientes) {
        String leftAlignFormat = "|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%n";

        System.out.format(
                "+---------------+---------------+---------------+---------------+---------------+-----------------------+---------------+%n");
        System.out.format(
                "|CNS            |Nome           |CPF            | Data de Nasc  |Sexo           | Nome da mãe           |%n");
        System.out.format(
                "+---------------+---------------+---------------+---------------+---------------+-----------------------+---------------+%n");
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i) != null && pacientes.get(i).getCPF() != null) {

                String nome = pacientes.get(i).getNome();
                String dtNasc = pacientes.get(i).getDtNasc();
                String nomeMae = pacientes.get(i).getNomeMae();
                String CPF = pacientes.get(i).getCPF();
                Sexo sexo = pacientes.get(i).getSexo();
                long CNS = pacientes.get(i).getCNS();

                if (nome != null) {

                    System.out.printf(leftAlignFormat, CNS, nome, CPF, dtNasc, sexo, nomeMae);
                    System.out.format(
                            "+---------------+---------------+---------------+---------------+---------------+-----------------------+---------------+%n");

                }

            }
        }
        System.out.println();
    }

    public String receberCPF() {
        System.out.println("Insira o CPF do paciente (Somente os números):");
        String CPF = sc.next();
        System.out.println();
        return CPF;
    }

    /*----------------------------------------------------------------------------------------------------------------------*/

    /*---------------------------------------------------- Usuário ----------------------------------------------------------*/

    public void atualizarUsuario(List<Usuario> usuarios) {
        System.out.println("Entre com o id do usuário que você deseja mudar");
        long id = sc.nextInt();
        System.out.println();

        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i) != null && usuarios.get(i).getNome() != null) {
                if (usuarios.get(i).getId() == id) {
                    System.out.println("Insira o nome do Usuário:");
                    String nome = sc.next();
                    nome += sc.nextLine();

                    System.out.println("Insira o nome do Login do Usuário:");
                    String nomeLogin = sc.next();
                    nomeLogin += sc.nextLine();

                    System.out.println("Insira a senha do Usuário:");
                    String senha = sc.next();
                    senha += sc.nextLine();

                    System.out.println("Insira o tipo do Usuário ( a - Atendente , m - Médico ):");
                    char tipo = sc.next().toLowerCase().charAt(0);

                    usuarios.get(i).setAtualizarUsuario(nome, nomeLogin, senha, tipo);
                }
            }
        }
    }

    public void criarUsuario(List<Usuario> usuarios) {

        System.out.println("Insira o nome do Usuário:");
        String nome = sc.next();
        nome += sc.nextLine();

        System.out.println("Insira o nome do Login do Usuário:");
        String nomeLogin = sc.next();
        nomeLogin += sc.nextLine();

        System.out.println("Insira a senha do Usuário:");
        String senha = sc.next();
        senha += sc.nextLine();

        System.out.println("Insira o tipo do Usuário ( a - Atendente , m - Médico ):");
        char tipo = sc.next().toLowerCase().charAt(0);

        for (int i = 0; i < usuarios.size(); i++) {
            // if (usuarios.get(i).getSenha() == null) {
            usuarios.get(i).setUsuario(nome, nomeLogin, senha, tipo);
            System.out.println("Usuário cadastrado com sucesso!");
            break;
            // }
        }

    }

    public void excluirUsuario(List<Usuario> usuarios) {
        System.out.println("Digite o ID do usuario a ser excluído : ");
        int idUser = sc.nextInt();
        String senha;
        boolean validacao = false;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i) != null && usuarios.get(i).getNome() != null) {
                if (usuarios.get(i).getId() == idUser) {
                    System.out.println("Usuario encontrado! Digite a senha do usuario a ser excluído : ");
                    senha = sc.next();
                    senha += sc.nextLine();
                    System.out.println();
                    if (usuarios.get(i).getSenha().equals(senha)) {
                        usuarios.add(i, null);
                        ;
                        validacao = true;
                    }
                }
            }
        }
        if (validacao) {
            System.out.println("Usuario excluído\n");
        } else {
            System.out.println("Usuario não excluido\n");
        }
    }

    public void listarUsuarios(List<Usuario> usuarios) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i) != null) {

                long Id = usuarios.get(i).getId();
                String nome = usuarios.get(i).getNome();
                String nomeLogin = usuarios.get(i).getNomeLogin();
                Tipo tipo = usuarios.get(i).getTipo();

                if (nome != null) {

                    System.out.println(
                            "--------------------------------------------------------------------------------\n"
                                    + "ID : " + Id + "\n" + "nome : " + nome +
                                    "\n" + "Nome de login : " + nomeLogin + "\n" +
                                    "Tipo : " + tipo +
                                    "\n");
                }
            }
        }
    }

    /*----------------------------------------------------------------------------------------------------------------------*/

    /*----------------------------------------------------------------------------------------------------------------------*/

    /*---------------------------------------------------- Anamnese ----------------------------------------------------------*/

    public void atualizarAnamnse(List<Anamnese> anamneses, List<Paciente> pacientes) {
        System.out.println("Insira o ID da anamnese que será modificada:");
        int id = sc.nextInt();

        for (int i = 0; i < anamneses.size(); i++) {
            if (anamneses.get(i) != null && anamneses.get(i).getMotivo() != null) {

                if (anamneses.get(i).getId() == id) {
                    System.out.println("Insira o motivo da anamnese:");
                    String motivo = sc.next();
                    motivo += sc.nextLine();
                    System.out.println();

                    System.out.println("Insira o historico do paciente:");
                    String historico = sc.next();
                    historico += sc.nextLine();
                    System.out.println();

                    System.out.println("Insira a queixa do paciente:");
                    String queixa = sc.next();
                    queixa += sc.nextLine();
                    System.out.println();

                    System.out.println("Insira o CPF do paciente (apenas numeros) :");
                    String CPF = sc.next();
                    System.out.println();

                    Paciente pacienteAnamnese = encontrarPaciente(CPF, pacientes);

                    anamneses.get(i).setAtualizarAnamnese(motivo, historico, queixa, pacienteAnamnese);
                }
            }
        }
    }

    public boolean criarAnamnese(List<Anamnese> anamneses, List<Paciente> pacientes) {
        System.out.println("Insira o motivo da anamnese:");
        String motivo = sc.next();
        motivo += sc.nextLine();
        System.out.println();

        System.out.println("Insira o historico do paciente:");
        String historico = sc.next();
        historico += sc.nextLine();
        System.out.println();

        System.out.println("Insira a queixa do paciente:");
        String queixa = sc.next();
        queixa += sc.nextLine();
        System.out.println();

        System.out.println("Insira o CPF do paciente (apenas numeros) :");
        String CPF = sc.next();
        System.out.println();

        Paciente pacienteAnamnese = encontrarPaciente(CPF, pacientes);
        for (int i = 0; i < anamneses.size(); i++) {
            if (anamneses.get(i).getQueixa() == null) {
                anamneses.get(i).setAnamnese(motivo, historico, queixa, pacienteAnamnese);
                System.out.println("Anamnese criada com sucesso!\n");
                break;

            }
        }
        return true;
    }

    public void excluirAnamnese(long id, List<Anamnese> anamneses) {
        boolean validacao = false;
        for (int i = 0; i < anamneses.size(); i++) {
            if (anamneses.get(i).getId() == id) {
                anamneses.add(i, null);
                validacao = true;
            }
        }
        if (validacao) {

            System.out.println("Anamnese excluída\n");
        } else {
            System.out.println("Anamnese não encontrada\n");
        }
    }

    public Paciente encontrarPaciente(String CPF, List<Paciente> pacientes) {
        String cpf = CPF;
        if (!validacao.validaCPF(cpf, pacientes)) {
            while (!validacao.validaCPF(cpf, pacientes)) {
                System.out.println("CPF não encontrado, por favor:");
                System.out.println("Insira o CPF do paciente (apenas numeros) :");
                cpf = sc.next();
                cpf += sc.nextLine();
                System.out.println();
            }
        }
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i) != null && pacientes.get(i).getNome() != null) {
                if (pacientes.get(i).getCPF().equals(cpf)) {
                    return pacientes.get(i);
                }
            }
        }
        return null;
    }

    public void listarAnamneses(List<Anamnese> anamneses) {
        for (int i = 0; i < anamneses.size(); i++) {
            if (anamneses.get(i) != null && anamneses.get(i).getMotivo() != null) {
                String motivo = anamneses.get(i).getMotivo();
                String historico = anamneses.get(i).getHistorico();
                String queixa = anamneses.get(i).getQueixa();
                String pacienteNome = anamneses.get(i).getPaciente().getNome();
                long id = anamneses.get(i).getId();

                System.out.println("--------------------------------------------------------------------------------\n"
                        + "Id : " + id + "\n" + "Nome do paciente : " + pacienteNome + "\n" + "Queixa : " + queixa
                        + "\n"
                        + "Motivo : " + motivo + "\n" + "Histórico : " + historico + "\n");
            }

        }
        System.out.println();
    }

    /*----------------------------------------------------------------------------------------------------------------------*/

}
