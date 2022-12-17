package view;

import java.util.List;
import java.util.Scanner;
import control.Sistema;
import models.Anamnese;
import models.Paciente;
import models.Usuario;

public class MedicoView {

    static Sistema sistema = new Sistema();
    static Scanner sc = new Scanner(System.in);

    public void boasVindasMedico(String login, String senha, List<Usuario> usuarios, List<Anamnese> anamneses,
            List<Paciente> pacientes) {
        System.out.println("Olá Médico " + sistema.getNome(login, senha, usuarios));
        menuPrincipalMedico(usuarios, anamneses, pacientes);
    }

    public int mostraMenuMedico() {

        System.out.println("por favor escolha o que deseja fazer:");
        System.out.println(
                "1- Criar Anamnese \n2- Listar Anamnese\n3- Atualizar Anamnese\n4- Deletar Anamnese\n5- Trocar o usuário\n6- Sair");
        int op = sc.nextInt();
        System.out.println();
        return op;
    }

    public void menuPrincipalMedico(List<Usuario> usuarios, List<Anamnese> anamneses, List<Paciente> pacientes) {
        int op = mostraMenuMedico();
        while (op < 1 || op > 6) {
            System.out.println("Opção impossível");
            op = mostraMenuMedico();
        }
        while (op != 6) {

            switch (op) {
                case 1:
                    sistema.criarAnamnese(anamneses, pacientes);
                    break;

                case 2:
                    sistema.listarAnamneses(anamneses);
                    break;

                case 3:
                    sistema.atualizarAnamnse(anamneses, pacientes);
                    break;

                case 4:
                    System.out.println("Insira o id da Anamnese a ser excluída:");
                    int escolhaID = sc.nextInt();
                    sistema.excluirAnamnese(escolhaID, anamneses);
                    break;
                case 5:
                    padraoView.menutotal(null, null, usuarios);
                    break;
            }
            op = mostraMenuMedico();
            while (op < 1 || op > 6) {
                System.out.println("Opção impossível");
                op = mostraMenuMedico();
            }
        }
        System.out.println("Até mais!");
        System.exit(0);
    }

}
