package view;

import java.util.List;
import java.util.Scanner;
import control.Sistema;
import models.Anamnese;
import models.Paciente;
import models.Usuario;

public class AtendenteView {
    static Sistema sistema = new Sistema();
    static Scanner sc = new Scanner(System.in);

    public void boasVindasAtendente(String login, String senha, List<Paciente> pacientes, List<Anamnese> anamneses,
            List<Usuario> usuarios) {
        System.out.println("Olá Atendente " + sistema.getNome(login, senha, usuarios));
        menuPrincipalAtendente(pacientes, anamneses, usuarios);
    }

    public int mostraMenuAtendente() {

        System.out.println("por favor escolha o que deseja fazer:");
        System.out.println(
                "1- Criar \n2- Listar\n3- Atualizar\n4- Deletar\n5- Trocar de usuário\n6- Sair");
        int op = sc.nextInt();
        System.out.println();
        return op;
    }

    public int mostraMenuAtualizarAtendente() {
        System.out.println("Selecione o que você deseja atualizar:");
        System.out.println("1- Paciente\n2- Usuário");
        int op = sc.nextInt();
        System.out.println();
        return op;
    }

    public int mostraMenuCriarAtendente() {
        System.out.println("Selecione o que você deseja criar:");
        System.out.println("1- Paciente\n2- Usuário");
        int op = sc.nextInt();
        System.out.println();
        return op;
    }

    public int mostraMenuExcluirAtendente() {
        System.out.println("Selecione o que você deseja excluir:");
        System.out.println("1- Paciente\n2- Usuário");
        int op = sc.nextInt();
        System.out.println();
        return op;
    }

    public int mostraMenuListarAtendente() {
        System.out.println("Selecione o que você deseja listar:");
        System.out.println("1- Paciente\n2- Usuário");
        int op = sc.nextInt();
        System.out.println();
        return op;
    }

    public void menuPrincipalAtendente(List<Paciente> pacientes, List<Anamnese> anamneses, List<Usuario> usuarios) {
        int op = mostraMenuAtendente();
        while (op < 1 || op > 6) {
            System.out.println("Opção impossível");
            op = mostraMenuAtendente();
        }
        while (op != 6) {

            switch (op) {
                case 1:
                    int opç = mostraMenuCriarAtendente();
                    while (opç < 1 || opç > 2) {
                        System.out.println("Opção impossível");
                        opç = mostraMenuCriarAtendente();
                    }
                    switch (opç) {
                        case 1:
                            sistema.criarPaciente(pacientes);
                            break;

                        case 2:
                            sistema.criarUsuario(usuarios);
                            break;
                    }
                    break;

                case 2:
                    opç = mostraMenuListarAtendente();
                    while (opç < 1 || opç > 2) {
                        System.out.println("Opção impossível");
                        opç = mostraMenuListarAtendente();
                    }
                    switch (opç) {
                        case 1:
                            sistema.listarPacientes(pacientes);
                            break;

                        case 2:
                            sistema.listarUsuarios(usuarios);
                            break;
                    }
                    break;

                case 3:
                    opç = mostraMenuAtualizarAtendente();
                    while (opç < 1 || opç > 2) {
                        System.out.println("Opção impossível");
                        opç = mostraMenuAtualizarAtendente();
                    }
                    switch (opç) {
                        case 1:
                            sistema.atualizarPaciente(pacientes);
                            break;

                        case 2:
                            sistema.atualizarUsuario(usuarios);
                            break;
                    }
                    break;

                case 4:
                    opç = mostraMenuExcluirAtendente();
                    while (opç < 1 || opç > 2) {
                        System.out.println("Opção impossível");
                        opç = mostraMenuExcluirAtendente();
                    }
                    switch (opç) {
                        case 1:
                            String cpf;
                            System.out.println("Digite o CPF do paciente a ser excluído : ");
                            cpf = sc.next();
                            sistema.excluirPaciente(cpf, pacientes, anamneses);
                            break;

                        case 2:
                            sistema.excluirUsuario(usuarios);
                            break;
                    }
                    break;
                case 5:
                    padraoView.menutotal(pacientes, anamneses, usuarios);
                    break;
            }
            op = mostraMenuAtendente();
            while (op < 1 || op > 6) {
                System.out.println("Opção impossível");
                op = mostraMenuAtendente();
            }
        }
        System.out.println("Até mais!");
        System.exit(0);
    }

}