package view;

import java.util.Scanner;
import control.Sistema; 

public class MedicoView {

    static Sistema sistema = new Sistema();
    static Scanner sc = new Scanner(System.in);

    public void boasVindasMedico(String login, String senha) {
        System.out.println("Olá Médico " + sistema.getNome(login, senha));
        menuPrincipalMedico();
    }

    public int mostraMenuMedico() {

        System.out.println("por favor escolha o que deseja fazer:");
        System.out.println("1- Criar Anamnese \n2- Listar Anamnese\n3- Atualizar Anamnese\n4- Deletar Anamnese\n5- Trocar o usuário\n6- Sair");
        int op = sc.nextInt();
        System.out.println();
        return op;
    }

    public void menuPrincipalMedico() {
        int op = mostraMenuMedico();
        while (op < 1 || op > 6) {
            System.out.println("Opção impossível");
            op = mostraMenuMedico();
        }
        while (op != 6) {

            switch (op) {
                case 1:
                    sistema.criarAnamnese();
                    break;

                case 2:
                    sistema.listarAnamneses();
                    break;

                case 3:
                    sistema.atualizarAnamnse();
                    break;

                case 4:
                    System.out.println("Insira o id da Anamnese a ser excluída:");
                    int escolhaID = sc.nextInt();
                    sistema.excluirAnamnese(escolhaID);
                    break;
                case 5:
                    padraoView.menutotal();
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
