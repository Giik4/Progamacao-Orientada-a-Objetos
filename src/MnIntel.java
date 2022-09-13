//Nome: Giovanni Siervo - RA: 2144255

public class MnIntel {

    private BancoIntel bancoInt = new BancoIntel();
    private Scan s = new Scan();
    private Intel itl = new Intel();

    private boolean ctrlCodInt = true;

    public void menuInt() {

        boolean ctrlInt = true;
        int opInt = 0;

        while (ctrlInt) {

            System.out.println("\n\t\t ____Cadastro processador Intel____");

            System.out.println("\n\t (1) Cadastrar processador ");
            System.out.println("\t (2) Mostrar todos os processadores");
            System.out.println("\t (3) Consultar processador pelo código");
            System.out.println("\t (4) Alterar processador pelo código");
            System.out.println("\t (5) Excluir processador pelo código");
            System.out.println("\t (6) Voltar ao menu principal");

            try {
                opInt = Integer.parseInt(s.entDados("\nEscolha uma opção: "));
            } catch (NumberFormatException nfe) {
                s.entDados("\nA opção deve ser um inteiro! - Press <Enter>");
                continue;
            }

            switch (opInt) {

                case 1:
                    itl = new Intel();

                    itl = bancoInt.cadIntel(itl);

                    bancoInt.getBDIntel().add(itl);

                    break;

                case 2:
                    System.out.println("\nMostrar todos os processadores - Press <Enter>");

                    for (int i = 0; i < bancoInt.getBDIntel().size(); i++) {
                        bancoInt.impIntel(bancoInt.getBDIntel().get(i));
                    }

                    break;

                case 3:
                    ctrlCodInt = true;

                    itl = new Intel();

                    while (ctrlCodInt) {
                        try {
                            itl.setCod(Integer.parseInt(s.entDados("\nCódigo a ser consultado..: ")));
                            ctrlCodInt = false;
                        } catch (NumberFormatException nfe) {
                            s.entDados("\n O código deve ser um valor inteiro - Press <Enter>");
                            continue;
                        }
                    }

                    itl = bancoInt.consIntelCod(itl);

                    if (itl == null) {
                        s.entDados("\n Não há processador cadastrado com esse código! - Press <Enter>");
                    } else {
                        bancoInt.impIntel(itl);
                    }

                    break;

                case 4:
                    ctrlCodInt = true;

                    itl = new Intel();

                    while (ctrlCodInt) {
                        try {
                            itl.setCod(Integer.parseInt(s.entDados("\nCódigo a ser alterado: ")));
                            ctrlCodInt = false;
                        } catch (NumberFormatException nfe) {
                            s.entDados("\n O código deve ser um valor inteiro - Press <Enter>");
                            continue;
                        }
                    }

                    itl = bancoInt.alteraIntel(itl);

                    if (itl != null) {
                        s.entDados("\n Processador alterado com sucesso! Press <Enter> para ver as alterações");
                        bancoInt.impIntel(itl);
                    } else {
                        s.entDados("\n Não há processador cadastrado com esse código! - Press <Enter>");
                    }

                    break;

                case 5:
                    ctrlCodInt = true;

                    itl = new Intel();

                    while (ctrlCodInt) {
                        try {
                            itl.setCod(Integer.parseInt(s.entDados("\nCódigo do processador a ser excluido..: ")));
                            ctrlCodInt = false;
                        } catch (NumberFormatException nfe) {
                            s.entDados("\n O código deve ser um valor inteiro - Press <Enter>");
                            continue;
                        }
                    }

                    itl = bancoInt.excluiIntel(itl);

                    if (itl != null) {
                        s.entDados("\n Processador removido com sucesso - Press <Enter>");
                    } else {
                        s.entDados("\n Não há processador cadastrado com esse código! - Press <Enter>");
                    }

                    break;

                case 6:
                    ctrlInt = false;

                    break;

                default:
                    s.entDados("\nDeve escolher as opções de 1 a 6 - Press <Enter>");

                    break;
            }
        }
    }
}
