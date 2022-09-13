//Nome: Giovanni Siervo - RA: 2144255

import java.util.List;
import java.util.ArrayList;

public class BancoIntel{

    private List<Intel> BDIntel = new ArrayList<Intel>();
    private Intel itl = new Intel();
    private Scan s = new Scan();

    public List<Intel> getBDIntel(){
        return BDIntel;
    }

    public Intel consIntelCod(Intel itl){

        for(int i = 0; i < BDIntel.size(); i++){
            if(BDIntel.get(i).getCod() == itl.getCod()){
                return BDIntel.get(i);
            }
        }

        return null;
    }

    public Intel cadIntel(Intel itl){

        boolean ctrlCodInt = true;

        while(ctrlCodInt){
            try{
                itl.setCod(Integer.parseInt(s.entDados("\nCódigo..: ")));

                if(consIntelCod(itl) == null){
                    ctrlCodInt = false;
                }
                else{
                    s.entDados("\n Já foi cadastrado um processador com esse código! - Press <Enter>");
                    continue;
                }
            }
            catch(NumberFormatException nfe){
                s.entDados("\n O código deve ser inteiro - Press <Enter>");
                continue;
            }
        }

        boolean ctrlModInt = true;

        while(ctrlModInt){
            try{
                itl.setModInt(s.entDados("Modelo Intel: "));
                break;
            }
            catch(ModException me){
                me.impMsgMod();
                itl = me.fixMsgMod(itl);
                break;
            }
        }

        boolean ctrlGerInt = true;

        while(ctrlGerInt){
            try{
                itl.setGerInt(Integer.parseInt(s.entDados("Geração do modelo:")));
                break;
            }
            catch(NumberFormatException nfe){
                s.entDados("\n O valor deve ser um inteiro!- Press <Enter>" );
            }
        }

        itl.setSoqInt(s.entDados("Tipo de soquete Intel: "));

        boolean ctrlNucInt = true;

        while(ctrlNucInt){
            try{
                itl.setNucleos(Integer.parseInt(s.entDados("Nº de núcleos:")));
                break;
            }
            catch(NumberFormatException nfe){
                s.entDados("\n O valor deve ser um inteiro!- Press <Enter>" );
            }
        }

        boolean ctrlThrInt = true;

        while(ctrlThrInt){
            try{
                itl.setThreads(Integer.parseInt(s.entDados("Nº de threads: ")));
                break;
            }
            catch(NumberFormatException nfe){
                s.entDados("\n O valor deve ser um inteiro!- Press <Enter>" );
            }
        }

        boolean ctrlGhzInt = true;

        while(ctrlGhzInt){
            try{
                itl.setClock(Float.parseFloat(s.entDados("Frequência base (GHz): ")));
                break;
            }
            catch(NumberFormatException nfe){
                s.entDados("\n O valor deve ser um número!- Press <Enter>" );
            }
        }

        itl.setVideo(s.entDados("Vídeo integrado: "));

        boolean ctrlMaxInt = true;

        while(ctrlMaxInt){
            try{
                itl.getMemor().setMax(Integer.parseInt(s.entDados("Memória máxima (GB): ")));
                break;
            }
            catch(NumberFormatException nfe){
                s.entDados("\n O valor deve ser um inteiro!- Press <Enter>" );
            }
        }

        itl.getMemor().setTipo(s.entDados("Tipo de memória: "));

        boolean ctrlCacheInt = true;

        while(ctrlCacheInt){
            try{
                itl.getMemor().setCache(Integer.parseInt(s.entDados("Cache (MB): ")));
                break;
            }
            catch(NumberFormatException nfe){
                s.entDados("\n O valor deve ser um inteiro!- Press <Enter>" );
            }
        }

        return itl;

    }

    public void impIntel(Intel itl){

        System.out.println("\nCódigo...............: "+ itl.getCod());
        System.out.println("Modelo Intel.........: "+ itl.getModInt());
        System.out.println("Geração do modelo....: "+ itl.getGerInt());
        System.out.println("Tipo de soquete Intel: "+ itl.getSoqInt());

        System.out.println("Nº de núcleos........: "+ itl.getNucleos());
        System.out.println("Nº de threads........: "+ itl.getThreads());
        System.out.println("Frequência base (GHz): "+ itl.getClock());
        System.out.println("Vídeo integrado (S/N): "+ itl.getVideo());

        System.out.println("Memória máxima (GB)..: "+ itl.getMemor().getMax());
        System.out.println("Tipo de memória......: "+ itl.getMemor().getTipo());
        System.out.println("Cache (MB)...........: "+ itl.getMemor().getCache());

        itl.impForn();

        s.entDados("\n\t\t\t Press <Enter> para continuar... ");

    }

    public Intel alteraIntel(Intel itl){

        for(int i = 0; i < BDIntel.size(); i++){

            if(BDIntel.get(i).getCod() == itl.getCod()){

                itl = cadIntel(itl);
                BDIntel.set(i, itl);

                return BDIntel.get(i);
            }
        }
        return null;
    }

    public Intel excluiIntel(Intel itl){

        itl = consIntelCod(itl);

        if(BDIntel.remove(itl)){
            return itl;
        }
        return null;
    }

}
