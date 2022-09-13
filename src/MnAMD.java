//Nome: Giovanni Siervo - RA: 2144255

public class MnAMD {

    private BancoAMD bancoAmd = new BancoAMD();
    private Scan s = new Scan();
    private AMD a = new AMD();
    private boolean ctrlCodAmd = true;

    public void menuAmd() {

        boolean ctrlAmd = true;
        int opAmd = 0;

        while (ctrlAmd) {

            System.out.println("\n\t\t ____Cadastro processador AMD____");

            System.out.println("\n\t (1) Cadastrar processador ");
            System.out.println("\t (2) Mostrar todos os processadores");
            System.out.println("\t (3) Consultar processador pelo código");
            System.out.println("\t (4) Alterar processador pelo código");
            System.out.println("\t (5) Excluir processador pelo código");
            System.out.println("\t (6) Voltar ao menu principal");

            try {
                opAmd = Integer.parseInt(s.entDados("\nEscolha uma opção: "));
            } catch (NumberFormatException nfe) {
                s.entDados("\nA opção deve ser um inteiro! - Press <Enter>");
                continue;
            }

            switch (opAmd) {

                case 1:
                    a = new AMD();

                    a = bancoAmd.cadAmd(a);
                    bancoAmd.getBDAmd().add(a);

                    break;

                case 2:
                    System.out.println("\nMostrar todos os processadores - Press <Enter>");

                    for (int i = 0; i < bancoAmd.getBDAmd().size(); i++) {
                        bancoAmd.impAmd(bancoAmd.getBDAmd().get(i));
                    }

                    break;

                case 3:
                    ctrlCodAmd = true;

                    a = new AMD();

                    while (ctrlCodAmd) {
                        try {
                            a.setCod(Integer.parseInt(s.entDados("\nCódigo a ser consultado..: ")));
                            ctrlCodAmd = false;
                        } catch (NumberFormatException nfe) {
                            s.entDados("\n O código deve ser um valor inteiro - Press <Enter>");
                            continue;
                        }
                    }

                    a = bancoAmd.consAmdCod(a);

                    if (a == null) {
                        s.entDados("\n Não há processador cadastrado com esse código! - Press <Enter>");
                    } else {
                        bancoAmd.impAmd(a);
                    }

                    break;

                case 4:
                    ctrlCodAmd = true;

                    a = new AMD();

                    while (ctrlCodAmd) {
                        try {
                            a.setCod(Integer.parseInt(s.entDados("\nCódigo a ser alterado: ")));
                            ctrlCodAmd = false;
                        } catch (NumberFormatException nfe) {
                            s.entDados("\n O código deve ser um valor inteiro - Press <Enter>");
                            continue;
                        }
                    }

                    a = bancoAmd.alteraAmd(a);

                    if (a != null) {
                        s.entDados("\n Processador alterado com sucesso! Press <Enter> para ver as alterações");
                        bancoAmd.impAmd(a);
                    } else {
                        s.entDados("\n Não há processador cadastrado com esse código! - Press <Enter>");
                    }

                    break;

                case 5:
                    ctrlCodAmd = true;

                    a = new AMD();

                    while (ctrlCodAmd) {
                        try {
                            a.setCod(Integer.parseInt(s.entDados("\nCódigo do processador a ser excluido: ")));
                            ctrlCodAmd = false;
                        } catch (NumberFormatException nfe) {
                            s.entDados("\n O código deve ser um valor inteiro - Press <Enter>");
                            continue;
                        }
                    }

                    a = bancoAmd.excluiAmd(a);

                    if (a != null) {
                        s.entDados("\n Processador removido com sucesso - Press <Enter>");
                    } else {
                        s.entDados("\n Não há processador cadastrado com esse código! - Press <Enter>");
                    }

                    break;

                case 6:
                    ctrlAmd = false;

                    break;

                default:
                    s.entDados("\nDeve escolher as opções de 1 a 6 - Press <Enter>");

                    break;
            }
        }
    }
}
