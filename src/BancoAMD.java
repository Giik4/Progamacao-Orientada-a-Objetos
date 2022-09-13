//Nome: Giovanni Siervo - RA: 2144255

import java.util.ArrayList;
import java.util.List;

public class BancoAMD {

    private List<AMD> BDAmd = new ArrayList<AMD>();
    private AMD a = new AMD();
    private Scan s = new Scan();

    public List<AMD> getBDAmd(){
        return BDAmd;
    }

    public AMD consAmdCod(AMD a){

        for(int i = 0; i < BDAmd.size(); i++){
            if(BDAmd.get(i).getCod() == a.getCod()){
                return BDAmd.get(i);
            }
        }
        return null;
    }

    public AMD cadAmd(AMD a){

        boolean ctrlCodAmd = true;

        while(ctrlCodAmd){
            try{
                a.setCod(Integer.parseInt(s.entDados("\nCódigo..: ")));

                if(consAmdCod(a) == null){
                    ctrlCodAmd = false;
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

        a.setModAmd(s.entDados("Modelo AMD: "));

        boolean ctrlGerAmd = true;

        while(ctrlGerAmd){
            try{
               a.setGerAmd(Integer.parseInt(s.entDados("Geração do modelo:")));
                break;
            }
            catch (GerException ge){
                ge.impMsgGer();
                a = ge.fixMsgGer(a);
                break;
            }
            catch(NumberFormatException nfe){
                s.entDados("\n O valor deve ser um inteiro!- Press <Enter>" );
            }
        }

        a.setSoqAmd(s.entDados("Tipo de soquete AMD: "));

        boolean ctrlNucInt = true;

        while(ctrlNucInt){
            try{
                a.setNucleos(Integer.parseInt(s.entDados("Nº de núcleos:")));
                break;
            }
            catch(NumberFormatException nfe){
                s.entDados("\n O valor deve ser um inteiro!- Press <Enter>" );
            }
        }

        boolean ctrlThrAmd = true;

        while(ctrlThrAmd){
            try{
                a.setThreads(Integer.parseInt(s.entDados("Nº de threads: ")));
                break;
            }
            catch(NumberFormatException nfe){
                s.entDados("\n O valor deve ser um inteiro!- Press <Enter>" );
            }
        }

        boolean ctrlGhzAmd = true;

        while(ctrlGhzAmd){
            try{
                a.setClock(Float.parseFloat(s.entDados("Frequência base (GHz): ")));
                break;
            }
            catch(NumberFormatException nfe){
                s.entDados("\n O valor deve ser um número!- Press <Enter>" );
            }
        }

        a.setVideo(s.entDados("Vídeo integrado: "));

        boolean ctrlMaxAmd = true;

        while(ctrlMaxAmd){
            try{
                a.getMemor().setMax(Integer.parseInt(s.entDados("Memória máxima (GB): ")));
                break;
            }
            catch(NumberFormatException nfe){
                s.entDados("\n O valor deve ser um inteiro!- Press <Enter>" );
            }
        }

        a.getMemor().setTipo(s.entDados("Tipo de memória: "));

        boolean ctrlCacheAmd = true;

        while(ctrlCacheAmd){
            try{
                a.getMemor().setCache(Integer.parseInt(s.entDados("Cache (MB): ")));
                break;
            }
            catch(NumberFormatException nfe){
                s.entDados("\n O valor deve ser um inteiro!- Press <Enter>" );
            }
        }

        return a;

    }

    public void impAmd(AMD a){

        System.out.println("\nCódigo.............: "+ a.getCod());
        System.out.println("Modelo AMD...........: "+ a.getModAmd());
        System.out.println("Geração do modelo....: "+ a.getGerAmd());
        System.out.println("Tipo de soquete AMD..: "+ a.getSoqAmd());

        System.out.println("Nº de Núcleos........: "+ a.getNucleos());
        System.out.println("Nº de threads........: "+ a.getThreads());
        System.out.println("Frequência base (GHz): "+ a.getClock());
        System.out.println("Vídeo integrado (S/N): "+ a.getVideo());

        System.out.println("Memória máxima (GB)..: "+ a.getMemor().getMax());
        System.out.println("Tipo de memória......: "+ a.getMemor().getTipo());
        System.out.println("Cache (MB)...........: "+ a.getMemor().getCache());

        a.impForn();

        s.entDados("\n\t\t\t Press <Enter> para continuar... ");

    }

    public AMD alteraAmd(AMD a){

        for(int i = 0; i < BDAmd.size(); i++){

            if(BDAmd.get(i).getCod() == a.getCod()){

                a = cadAmd(a);
                BDAmd.set(i, a);

                return BDAmd.get(i);
            }
        }
        return null;
    }

    public AMD excluiAmd(AMD a){

        a = consAmdCod(a);

        if(BDAmd.remove(a)){
            return a;
        }
        return null;
    }

}

