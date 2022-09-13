//Nome: Giovanni Siervo - RA: 2144255

public class ModException extends Exception {

    Scan s = new Scan();

    public void impMsgMod(){
        System.out.println("\nO modelo inserido não existe");
    }

    public Intel fixMsgMod(Intel i){

        try{
            i.setModInt(s.entDados("Modelo Intel: "));
        }
        catch(ModException me){
            me.impMsgMod();
            me.fixMsgMod(i);
        }

        return i;
    }
}
