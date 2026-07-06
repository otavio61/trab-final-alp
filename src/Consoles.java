/*classe Consoles que possui os metodos get e set para nome, data de lancamento
empresa, codigo de busca e processo em bits do console*/ 

public class Consoles{
    
    //atributos da classe Console
    private String dataLanc;
    private String nome;
    private String empresa;
    private int codigoBusca;
    private int processoBits;

    public Consoles(String dL, String n, String e, int pB, int cB){
        dataLanc = dL;
        nome = n;
        empresa = e;
        processoBits = pB;
        codigoBusca = cB;
    }

    public Consoles(){}

    public String getNome(){
        return nome;
    }

    public void setNome(String n){
        nome = n;
        System.out.println("\n\n|------Nome alterado com sucesso!!!------|\n");
    }

    public String getEmpresa(){
        return empresa;
    }

    public void setEmpresa(String e){
        empresa = e;
        System.out.println("\n\n|------Empresa alterada com sucesso!!!------|\n");
    }

    public String getDataLanc(){
        return dataLanc;
    }

    public void setDataLanc(String dL){
        dataLanc = dL;
        System.out.println("\n\n|------Data de lancamento alterada com sucesso!!!------|\n");
    }

    public int getProcessoBits(){
        return processoBits;
    }

    public void setProcessoBits(int pB){
        processoBits = pB;
        System.out.println("\n\n|------Processo em Bits alterado com sucesso!!!------|\n");
    }

    public int getCodigo(){
        return codigoBusca;
    }

    public void setCodigo(int cB){
        codigoBusca = cB;
        System.out.println("\n\n|-----Codigo alterado com sucesso!!!------|\n");
    }
    
}