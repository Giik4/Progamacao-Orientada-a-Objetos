//Nome: Giovanni Siervo - RA: 2144255

public class GerException extends Exception{

    Scan s = new Scan();

    public void impMsgGer(){
        System.out.println("\nSomente números positivos para geração!");
    }

    public AMD fixMsgGer(AMD a){

        try{
            a.setGerAmd(Integer.parseInt(s.entDados("Geração do modelo:")));
        }
        catch (GerException ge){
            ge.impMsgGer();
            ge.fixMsgGer(a);
        }
        catch (NumberFormatException nfe){
            System.out.println("\nA geração deve ser um número inteiro");
        }

        return a;
    }
}
