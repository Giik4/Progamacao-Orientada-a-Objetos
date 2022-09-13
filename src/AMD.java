//Nome: Giovanni Siervo - RA: 2144255

public final class AMD extends Processador implements Fornecedor {

    private String modAmd;
    private int gerAmd;
    private String soqAmd;

    public AMD(){
        modAmd = "";
        gerAmd = 0;
        soqAmd = "";
    }

    public String getModAmd(){
        return modAmd;
    }

    public int getGerAmd(){
        return gerAmd;
    }

    public String getSoqAmd(){
        return soqAmd;
    }

    public void setModAmd(String modAmd){
        this.modAmd = modAmd;
    }

    public void setGerAmd(int gerAmd) throws GerException{

        if(gerAmd <= 0){
            throw new GerException();
        }
        else{
            this.gerAmd = gerAmd;
        }
    }

    public void setSoqAmd(String soqAmd){
        this.soqAmd = soqAmd;
    }

    public void impForn(){
        System.out.println("Fornecedor...........: "+Nome);
        System.out.println("Cnpj.................: "+cnpj);
    }
}
