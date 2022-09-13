//Nome: Giovanni Siervo - RA: 2144255

public final class Intel extends Processador implements Fornecedor{

    private String modInt;
    private int gerInt;
    private String soqInt;

    public Intel(){
        modInt = "";
        gerInt = 0;
        soqInt = "";
    }

    public String getModInt(){
        return modInt;
    }

    public int getGerInt(){
        return gerInt;
    }

    public String getSoqInt(){
        return soqInt;
    }

    public void setModInt(String modInt) throws ModException{

        if((modInt.equals("i3"))||(modInt.equals("i5"))||(modInt.equals("i7"))||(modInt.equals("i9"))){
            this.modInt = modInt;
        }
        else{
            throw new ModException();
        }
    }

    public void setGerInt(int gerInt){
        this.gerInt = gerInt;
    }

    public void setSoqInt(String soqInt){
        this.soqInt = soqInt;
    }

    public void impForn(){
        System.out.println("Fornecedor...........: "+Nome);
        System.out.println("Cnpj.................: "+cnpj);
    }
}
