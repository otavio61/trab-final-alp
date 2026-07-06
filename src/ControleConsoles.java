/*Classe para controle e manipulacao do vetor*/

import java.util.*;

public class ControleConsoles{
    private Scanner t = new Scanner(System.in);
    private Consoles c[] = new Consoles[4];

    // metodo para adicionar um novo console para o vetor caso haja espaco
    public void adicionarConsole(Consoles consoleX){

        for(int i = 0; i < c.length; i++){

            if(c[i] == null){
                c[i] = consoleX;

                return;
            }
        }
    }

    // metodo para mostrar o menu de opcoes baseado em CRUD
    public int Menu(){ 
        int opN;

        System.out.println("\n\n|--------------Menu Consoles----------------|");
        System.out.println("|                                           |");
        System.out.println("|1- Criar um novo console                   |");
        System.out.println("|                                           |");
        System.out.println("|2- Lista de Consoles                       |");
        System.out.println("|                                           |");
        System.out.println("|3- Mudar alguma informacao de algum console|");
        System.out.println("|                                           |");
        System.out.println("|4- Deletar Console                         |");
        System.out.println("|                                           |");
        System.out.println("|5- Sair                                    |");
        System.out.println("|                                           |");
        System.out.println("|-------------------------------------------|");
        System.out.print("\n|Digite uma opcao: ");
        opN = t.nextInt();

        return opN;
    }

    // metodo para criar um novo console
    public void criarConsole(){
        String nome, empresa, dataLanc;
        char escolha;
        int processoBits, codigoBusca;

        for(int i = 0; i < c.length; i++){

            if(c[i] == null){

                System.out.print("\n\n|-------------Cadastrando um Console-------------|\n\n");

                System.out.print("Digite o numero codigo do console: ");
                codigoBusca = t.nextInt();

                // verificacao se o codigo ja eh utilizado
                if(verificarCodigo(codigoBusca)){
                    System.out.println("\n\n|-------------Codigo ja esta sendo utilizado!--------------|");
                    System.out.print("\n|Digite qualquer tecla para retornar ao menu");
                    t.next();
                    return;
                }    

                System.out.print("Digite o nome do seu Console: ");
                t.nextLine();// scanner para pegar o "enter" digitado do teclado
                nome = t.nextLine();
        
                System.out.print("Digite o nome da sua empresa: ");
                empresa = t.nextLine();
        
                System.out.print("Digite a data de lancamento: ");
                dataLanc = t.nextLine();
        
                System.out.print("Digite o processamento de seu Console em bits: ");
                processoBits = t.nextInt();
        
                Consoles consoleNovo = new Consoles(dataLanc, nome, empresa, processoBits, codigoBusca);

                System.out.print("\n\nConfirmar Cadastro? [S/N]: ");
                escolha = t.next().charAt(0);

                if(escolha == 's' || escolha == 'S'){
                    adicionarConsole(consoleNovo);

                    System.out.println("\n\n|----------Console adicionado com sucesso!!!----------|\n");
                    System.out.print("\n|Digite qualquer tecla para retornar ao menu");
                    t.next();
                    return;
                }else{
                    System.out.println("\n\n|----------Cadastro Cancelado!!!----------|\n");
                    System.out.print("\n|Digite qualquer tecla para retornar ao menu");
                    t.next();
                    return;
                }
            }
        }
        System.out.println("\n\n|------Infelizmente nao ha espacos para a criacao de um novo console!------|\n");
        System.out.print("\n|Digite qualquer tecla para retornar ao menu");
        t.next();
    }

    // metodo para mostrar uma lista dos consoles no vetor
    public void lista(){

        if(verificarEspacos()){

            System.out.print("\n\n|------------------Lista dos Consoles------------------|");

            for(int i = 0; i < c.length; i++){

                if(c[i] != null){
                    System.out.printf("\n\n|------------------Console %d------------------|", i + 1);
                    System.out.printf("\n\n|Nome do console: %s", c[i].getNome());
                    System.out.printf("\n|Nome da empresa fabricante: %s", c[i].getEmpresa());
                    System.out.printf("\n|Data de lancamento na America: %s", c[i].getDataLanc());
                    System.out.printf("\n|Processamento em bits: %d", c[i].getProcessoBits());
                    System.out.printf("\n|Codigo do console: %d\n", c[i].getCodigo());
                }
            }
            System.out.print("\n|Digite qualquer tecla para retornar ao menu");
            t.next();

        }else{
            System.out.println("\n\n|----------Nao ha nenhum console para mostrar uma lista!----------|\n");
            System.out.print("\n|Digite qualquer tecla para retornar ao menu");
            t.next();
        }
    }

    // metodo que escolhe o console para editar suas informacoes
    public void editarConsole(){
        int op;

        if(verificarEspacos()){

            System.out.println("\n\n|------Escolha qual console voce deseja editar------|\n");
            
            do{
                for(int i = 0; i < c.length; i++){
        
                    if(c[i] != null)
                    System.out.printf("%d- %s\n\n", i + 1, c[i].getNome());
                }

                System.out.print("Escolha sua opcao: ");
                op = t.nextInt() - 1;

                if(op < 0 || op > c.length - 1 || c[op] == null){
                    System.out.println("\n\n|---------Digite um valor valido!---------|\n");

                    System.out.print("\n|Digite qualquer tecla para continuar");
                    t.next();
                }

            }while(op < 0 || op > c.length - 1 || c[op] == null);

            editarInfo(op);

        }else{
            System.out.println("\n\n|----------Nao ha nenhum console para editar informacoes----------|\n");
            System.out.print("\n|Digite qualquer tecla para retornar ao menu");
            t.next();
        }
    }

    // metodo que edita as informacoes do console escolhido no metodo acima
    private void editarInfo(int op){
        int opInfo, cod, procBt;
        String nome, dataL, empresa;

        do{
            System.out.print("\n\n|------Escolha qual informacao voce deseja editar------|\n\n");
            System.out.print("1- Codigo\n\n");
            System.out.print("2- Nome do console\n\n");
            System.out.print("3- Empresa criadora\n\n");
            System.out.print("4- Data de lancamento na America\n\n");
            System.out.print("5- Processamento em bits\n\n");
            System.out.print("Escolha sua opcao: ");
            opInfo = t.nextInt();

            switch(opInfo){
                case 1:
                    System.out.print("\n\nDigite qual sera o codigo novo do console: ");
                    cod = t.nextInt();

                    // estrutura de condicao para caso o codigo ja esta sendo utilizado
                    if(verificarCodigo(cod)){
                        System.out.println("\n\n|---------Codigo ja usado!---------|\n");
                        System.out.print("\n|Digite qualquer tecla para retornar ao menu");
                        t.next();

                    }else{
                        c[op].setCodigo(cod);
                        System.out.print("\n|Digite qualquer tecla para retornar ao menu");
                        t.next();
                    }
                break;

                case 2:
                    System.out.print("\nDigite qual sera o novo nome do console: ");
                    t.nextLine();// scanner para pegar o "enter" digitado do teclado
                    nome = t.nextLine();

                    c[op].setNome(nome);

                    System.out.print("\n|Digite qualquer tecla para retornar ao menu");
                    t.next();
                break;

                case 3:
                    System.out.print("\n|Digite qual sera o novo nome da empresa: ");
                    t.nextLine();// scanner para pegar o "enter" digitado do teclado
                    empresa = t.nextLine();

                    c[op].setEmpresa(empresa);

                    System.out.print("\n|Digite qualquer tecla para retornar ao menu");
                    t.next();
                break;

                case 4:
                    System.out.print("\n|Digite qual sera a nova data de lancamento: ");
                    t.nextLine();// scanner para pegar o "enter" digitado do teclado
                    dataL = t.nextLine();

                    c[op].setDataLanc(dataL);

                    System.out.print("\n|Digite qualquer tecla para retornar ao menu");
                    t.next();
                break;

                case 5:
                    System.out.print("\nDigite qual sera o novo valor de processamento em Bits: ");
                    procBt = t.nextInt();

                    c[op].setProcessoBits(procBt);

                    System.out.print("\n|Digite qualquer tecla para retornar ao menu");
                    t.next();
                break;

                default:
                    System.out.println("\n\n|----------Digite uma opcao valida!!!----------|");
                    System.out.print("\n|Digite qualquer tecla para continuar");
                    t.next();
            }

        }while(opInfo > 5 || opInfo < 1);
    }

    // metodo para validar o numero codigo
    private boolean verificarCodigo(int numCodigo){

        for(int i = 0; i < c.length; i++){

            if(c[i] != null){

                if(c[i].getCodigo() == numCodigo)
                return true;
            }
        }
        return false;
    }

    // metodo para verificar se o vetor esta vazio ou nao 
    private boolean verificarEspacos(){
        int verificaVetor = 0;

        for(int i = 0; i < c.length; i++){
            if(c[i] != null)
            verificaVetor++;
        }

        if(verificaVetor != 0)
            return true;
        else
            return false;
    }

    //metodo que exclui o Console do vetor
    public void ExcluirConsole(){
        int codigo;
        char escolha;

        if(verificarEspacos()){
            System.out.println("\n\n|------Digite o codigo do console que deseja excluir------|\n");

            // for para mostrar uma lista de consoles e seus codigos
            for(int i = 0; i < c.length; i++){

                if(c[i] != null)
                System.out.printf("|%s, codigo: %d\n\n", c[i].getNome(), c[i].getCodigo());
            }

            System.out.print("Escolha sua opcao: ");
            codigo = t.nextInt();

            if(verificarCodigo(codigo)){

                for(int i = 0; i < c.length; i++){

                    if(c[i] != null){

                        if(c[i].getCodigo() == codigo){
                            System.out.print("\n\nConfirmar Exclusao? [S/N]: ");
                            escolha = t.next().charAt(0);

                            if(escolha == 'S' || escolha == 's'){
                                c[i] = null;
    
                                System.out.println("\n\n|------Console excluido com sucesso!!!------|");
                                System.out.print("\n|Digite qualquer tecla para retornar ao menu");
                                t.next();
                                return;

                            }else{
                                
                                System.out.println("\n\n|------Exclusao cancelada!!!------|");
                                System.out.print("\n|Digite qualquer tecla para retornar ao menu");
                                t.next();
                                return;
                            }
                        }
                    }
                }

            }else{
                System.out.println("\n\n|------Nao ha nenhum console que possui esse codigo------|\n");
                System.out.print("\n|Digite qualquer tecla para retornar ao menu");
                t.next();
            }
            
        }else{
            System.out.println("\n\n|----------Nao ha nenhum console para excluir----------|\n");
            System.out.print("\n|Digite qualquer tecla para retornar ao menu");
            t.next();
        }         
    }
}
