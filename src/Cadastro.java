//Nome: Giovanni Siervo - RA: 2144255

import java.lang.NumberFormatException;

public class Cadastro {

	private static MnIntel mnIntel = new MnIntel();
	private static MnAMD mnAMD = new MnAMD();
	private static Scan s = new Scan();

	public static void main(String arg[]){
		boolean ctrlMP = true;
		int opMP = 0;

		while(ctrlMP){
			System.out.println("\n\t\t____Menu Principal____");

			System.out.println("\n\t (1) Cadastro de processadores Intel ");
			System.out.println("\t (2) Cadastro de processadores AMD");
			System.out.println("\t (3) Sair");

			try{
				opMP = Integer.parseInt(s.entDados("\nEscolha uma opção: "));
			}
			catch(NumberFormatException nfe){
				s.entDados("\nA opção deve ser um número inteiro - Press <Enter>");
				continue;
			}

			switch(opMP){

				case 1:
					mnIntel.menuInt();
					break;

//========================================================================================================================

				case 2:
					mnAMD.menuAmd();
					break;

//========================================================================================================================

				case 3:
					ctrlMP = false;
					break;

//========================================================================================================================


				default:
					s.entDados("\nDeve escolher valores entre 1 e 3 - Press <Enter>");
					break;


			}//fim do switch

		}//fim do while

	}//fim do main

}