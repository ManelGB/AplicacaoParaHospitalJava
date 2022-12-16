package view;

public class medicoView {
    
    public void boasVindasMedico(String login, String senha) {
        System.out.println("Olá Médico " + getNome(login, senha));
        menuPrincipalMedico();
    }

    public int mostraMenuMedico() {

        System.out.println("por favor escolha o que deseja fazer:");
        System.out.println(
                "1- Criar Anamnese \n2- Listar Anamnese\n3- Atualizar Anamnese\n4- Deletar Anamnese\n5- Trocar o usuário\n6- Sair");
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
                    criarAnamnese();
                    break;

                case 2:
                    listarAnamneses();
                    break;

                case 3:
                    atualizarAnamnse();
                    break;

                case 4:
                    System.out.println("Insira o id da Anamnese a ser excluída:");
                    int escolhaID = sc.nextInt();
                    excluirAnamnese(escolhaID);
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
