/*Programa sobre Consoles que foi criado com base no CRUD que possui um menu que o usuario pode escolher entre: criar, listar, editar, e deletar um Console, sendo os
mesmos sendo armazenados em um vetor, alem de tambem o vetor ja ser inicializado com 4 consoles e os objetos possuirem os metodos get e set
por: Otavio de Moraes, Kaio Vinicius
Prontuario: HT3015211, HT3010147
Criado em: 25/11/2022
Atualizado em: 01/12/2022*/
public class ConsoleEXE{

    public static void main(String[] args){
        ControleConsoles cal = new ControleConsoles();
        int opN;

        // objetos criados para padrao de execucao
        Consoles NES = new Consoles("18/10/1985", "Nintendo Entertainment System (NES)", "Nintendo", 8, 1);
        Consoles SNES = new Consoles("21/11/1991", "Super Nintendo Entertainment System (SNES)", "Nintendo", 16, 2);
        Consoles MegaDrive = new Consoles("14/8/1989", "SEGA Genesis (Mega Drive)", "Sega", 16, 3);
        Consoles PS2 = new Consoles("26/10/2000", "PlayStation 2 (PS2)", "Sony", 128, 4); 

        // adicionando os objetos ao vetor
        cal.adicionarConsole(NES);
        cal.adicionarConsole(SNES);
        cal.adicionarConsole(MegaDrive);
        cal.adicionarConsole(PS2);
        
        // estrutura de repeticao e selecao para os metodos da classe ControleConsoles
        do{
            opN = cal.Menu();

            switch(opN){
                case 1:
                    cal.criarConsole();
                break;

                case 2:
                    cal.lista();
                break;

                case 3:
                    cal.editarConsole();
                break;

                case 4:
                    cal.ExcluirConsole();
                break;

                case 5:
                    System.out.println("\n\n|----------Saindo do Progama----------|\n");
                break;

                default:
                    System.out.println("\n|----------Digite uma opcao valida!!!----------|");
            }

        }while(opN != 5);
    }
}
