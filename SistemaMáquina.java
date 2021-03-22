package com.alisson.refri;
import javax.swing.JOptionPane;

public class SistemaMáquina {
	
	/*
	PREÇO DOS COPOS
		300 ml = 3,50
		500 ml = 5,00
		700 ml = 8,25
	
	NÍVEL MÁXIMO DOS INGREDIENTES
		ÁGUA = 100 LITROS
		XAROPE COCA = 15 LITROS
		XAROPE FRUKI = 15 LITROS
		XAROPE FANTA = 15 LITROS
		GÁS = 100 doses
	*/
	
	boolean c5;
	
	double agua, gas, contadorAgua, contadorGas, contador300Coca, contador300Fruki, contador300Fanta, 
	       contador500Coca, contador500Fruki, contador500Fanta, contador700Coca, contador700Fruki, contador700Fanta,
	       contadorXaropeCoca, contadorXaropeFanta, contadorXaropeFruki, xaropeCoca, xaropeFruki, xaropeFanta;
    int copos300Coca, copos300Fruki, copos300Fanta, copos500Coca, copos500Fruki, copos500Fanta, 
    	copos700Coca, copos700Fruki, copos700Fanta;
		
	public boolean abastecerAgua() {
		contadorAgua += agua;
		if(agua > 100 || agua < 0 || contadorAgua > 100) {
			contadorAgua -= agua;
			return false;
		}
		return true;
	}
	
	public boolean abastecerXaropeCoca() {

		contadorXaropeCoca += xaropeCoca;
		if(xaropeCoca > 15 || xaropeCoca < 0 || contadorXaropeCoca > 15) {
			contadorXaropeCoca -= xaropeCoca;
			return false;
		}
		return true;
	}
	
	public boolean abastecerXaropeFruki() {

		contadorXaropeFruki += xaropeFruki;
		if(xaropeFruki > 15 || xaropeFruki < 0 || contadorXaropeFruki > 15) {
			contadorXaropeFruki -= xaropeFruki;
			return false;
		}
		return true;
	}
	
	public boolean abastecerXaropeFanta() {

		contadorXaropeFanta += xaropeFanta;
		if(xaropeFanta > 15 || xaropeFanta < 0 || contadorXaropeFanta > 15) {
			contadorXaropeFanta -= xaropeFanta;
			return false;
		}
		return true;
	}
	
	public boolean abastecerXaropeRefri() {

		int escolha = 1;
		
		while(escolha != 1 || escolha != 2 || escolha != 3 || escolha != 0) {
			
			escolha = Entrada.leiaInt("Digite uma opção: \n\n"
									+ "1 - Abastecer xarope Coca-Cola\n"
									+ "2 - Abastecer xarope Fruki\n"
									+ "3 - Abastecer xarope Fanta\n"
									+ "\n0 - Voltar ao meu anterior");
			
			if(escolha == 1) {
				xaropeCoca = Entrada.leiaDouble("Quanto você deseja abastecer? (Máximo 15 litros)");
				if(abastecerXaropeCoca() == false) {
					JOptionPane.showMessageDialog(null, "Operação inválida.");
				}
			}else if(escolha == 2){
				xaropeFruki = Entrada.leiaDouble("Quanto você deseja abastecer? (Máximo 15 litros)");
				if(abastecerXaropeFruki() == false) {
					JOptionPane.showMessageDialog(null, "Operação inválida.");
				}
			}else if(escolha == 3) {
				xaropeFanta = Entrada.leiaDouble("Quanto você deseja abastecer? (Máximo 15 litros)");
				if(abastecerXaropeFanta() == false) {
					JOptionPane.showMessageDialog(null, "Operação inválida.");
				}
			}else if(escolha == 0) {
				break;
			}else {
				JOptionPane.showMessageDialog(null, "Operação inválida.");
			}
		}
		return false;
	}

	public boolean abastecerGas() {
		contadorGas += gas;
		if(gas > 100 || gas < 0 || contadorGas > 100) {
			contadorGas -= gas;
			return false;
		}
		return true;
	}
	
	public boolean verificarNiveis() {
		 if(xaropeCoca > 15 || xaropeFruki > 15 || xaropeFanta > 15 || agua > 100 || gas > 100 || contadorAgua > 100 
		    || contadorXaropeCoca > 15 || contadorXaropeFruki > 15 || contadorXaropeFanta > 15 || contadorGas > 100
		    || contadorXaropeCoca == 0 || contadorXaropeFruki == 0 || contadorXaropeFanta == 0 || contadorGas < 3) {
			 return false;
		 }
		 return true;
	}
	
	public boolean verificarNivel300Coca() {
		if(contadorAgua >= 0.285 && contadorXaropeCoca >= 0.015 && contadorGas >= 3) {
			return true;
		}
		return false;
	}
	
	public boolean verificarNivel300Fruki() {
		if(contadorAgua >= 0.285 && contadorXaropeFruki >= 0.015 && contadorGas >= 3) {
			return true;
		}
		return false;
	}
	
	public boolean verificarNivel300Fanta() {
		if(contadorAgua >= 0.285 && contadorXaropeFanta >= 0.015 && contadorGas >= 3) {
			return true;
		}
		return false;
	}
	
	public boolean verificarNivel500Coca() {
		if(contadorAgua >= 0.475 && contadorXaropeCoca >= 0.025 && contadorGas >= 5) {
			return true;
		}
		return false;
	}
	
	public boolean verificarNivel500Fruki() {
		if(contadorAgua >= 0.475 && contadorXaropeFruki >= 0.025 && contadorGas >= 5) {
			return true;
		}
		return false;
	}
	
	public boolean verificarNivel500Fanta() {
		if(contadorAgua >= 0.475 && contadorXaropeFanta >= 0.025 && contadorGas >= 5) {
			return true;
		}
		return false;
	}
	
	public boolean verificarNivel700Coca() {
		if(contadorAgua >= 0.665 && contadorXaropeCoca >= 0.035 && contadorGas >= 7) {
			return true;
		}
		return false;
	}
	
	public boolean verificarNivel700Fruki() {
		if(contadorAgua >= 0.665 && contadorXaropeFruki >= 0.035 && contadorGas >= 7) {
			return true;
		}
		return false;
	}
	
	public boolean verificarNivel700Fanta() {
		if(contadorAgua >= 0.665 && contadorXaropeFanta >= 0.035 && contadorGas >= 7) {
			return true;
		}
		return false;
	}
	
	public int somatorioCopos() {
		return copos300Coca + copos300Fruki + copos300Fanta + copos500Coca + copos500Fruki + copos500Fanta + 
		       copos700Coca + copos700Fruki +  copos700Fanta;
	}
	
	public double valorTotal() {
		return contador300Coca + contador300Fruki + contador300Fanta + contador500Coca + 
			   contador500Fruki +  contador500Fanta + contador700Coca + contador700Fruki + contador700Fanta;
	}
	
	
	public boolean escolherCopoCoca() {
		
		int escolha = 1;
		
		while(escolha != 1 || escolha != 2 || escolha != 3 || escolha != 0) {
			
			escolha = Entrada.leiaInt("Digite uma opção: \n\n"
									+ "1 - Copo 300 ml\n"
									+ "2 - Copo 500 ml\n"
									+ "3 - Copo 700 ml\n"
									+ "\n0 - Voltar ao meu anterior");
			
			if(escolha == 1) {
				if(verificarNivel300Coca() == true) {
					contadorGas -= (1 * 3);
					contadorAgua -= (0.095 * 3);
					contadorXaropeCoca -= (0.005 * 3);
					contador300Coca += 3.50;
					copos300Coca += 1;
					return true;
				}else {
					JOptionPane.showMessageDialog(null, "Não é possível servir. Verifique o nível dos ingredientes ou escolha outro copo.");
				}
			}else if(escolha == 2){
				if(verificarNivel500Coca() == true) {
					contadorGas -= (1 * 5);
					contadorAgua -= (0.095 * 5);
					contadorXaropeCoca -= (0.005 * 5);
					contador500Coca += 5.00;
					copos500Coca += 1;
					return true;
				}else {
					JOptionPane.showMessageDialog(null, "Não é possível servir. Verifique o nível dos ingredientes ou escolha outro copo.");
				}
			}else if(escolha == 3) {
				if(verificarNivel700Coca() == true) {
					contadorGas -= (1 * 7);
					contadorAgua -= (0.095 * 7);
					contadorXaropeCoca -= (0.005 * 7);
					contador700Coca += 8.25;
					copos700Coca += 1;
					return true;
				}else {
					JOptionPane.showMessageDialog(null, "Não é possível servir. Verifique o nível dos ingredientes ou escolha outro copo.");
				}
			}else if(escolha == 0) {
				break;
			}else {
				JOptionPane.showMessageDialog(null, "Operação inválida.");
			}
		}
		return false;
	}
	
	public boolean escolherCopoFruki() {
		
		int escolha = 1;
		
		while(escolha != 1 || escolha != 2 || escolha != 3 || escolha != 0) {
			
			escolha = Entrada.leiaInt("Digite uma opção: \n\n"
									+ "1 - Copo 300 ml\n"
									+ "2 - Copo 500 ml\n"
									+ "3 - Copo 700 ml\n"
									+ "\n0 - Voltar ao meu anterior");
			
			if(escolha == 1) {
				if(verificarNivel300Fruki() == true) {
					contadorGas -= (1 * 3);
					contadorAgua -= (0.095 * 3);
					contadorXaropeFruki -= (0.005 * 3);
					contador300Fruki += 3.50;
					copos300Fruki += 1;
					return true;
				}else {
					JOptionPane.showMessageDialog(null, "Não é possível servir. Verifique o nível dos ingredientes ou escolha outro copo.");
				}
			}else if(escolha == 2){
				if(verificarNivel500Fruki() == true) {
					contadorGas -= (1 * 5);
					contadorAgua -= (0.095 * 5);
					contadorXaropeFruki -= (0.005 * 5);
					contador500Fruki += 5.00;
					copos500Fruki += 1;
					return c5 = true;
				}else {
					JOptionPane.showMessageDialog(null, "Não é possível servir. Verifique o nível dos ingredientes ou escolha outro copo.");
				}
			}else if(escolha == 3) {
				if(verificarNivel700Fruki() == true) {
					contadorGas -= (1 * 7);
					contadorAgua -= (0.095 * 7);
					contadorXaropeFruki -= (0.005 * 7);
					contador700Fruki += 8.25;
					copos700Fruki += 1;
					return true;
				}else {
					JOptionPane.showMessageDialog(null, "Não é possível servir. Verifique o nível dos ingredientes ou escolha outro copo.");
				}
			}else if(escolha == 0) {
				break;
			}else {
				JOptionPane.showMessageDialog(null, "Operação inválida.");
			}
		}
		return false;
	}

	public boolean escolherCopoFanta() {
	
	int escolha = 1;
	
	while(escolha != 1 || escolha != 2 || escolha != 3 || escolha != 0) {
		
		escolha = Entrada.leiaInt("Digite uma opção: \n\n"
								+ "1 - Copo 300 ml\n"
								+ "2 - Copo 500 ml\n"
								+ "3 - Copo 700 ml\n"
								+ "\n0 - Voltar ao meu anterior");
		
		if(escolha == 1) {
			if(verificarNivel300Fanta() == true) {
				contadorGas -= (1 * 3);
				contadorAgua -= (0.095 * 3);
				contadorXaropeFanta -= (0.005 * 3);
				contador300Fanta += 3.50;
				copos300Fanta += 1;
				return true;
			}else {
				JOptionPane.showMessageDialog(null, "Não é possível servir. Verifique o nível dos ingredientes ou escolha outro copo.");
			}
		}else if(escolha == 2){
			if(verificarNivel500Fanta() == true) {
				contadorGas -= (1 * 5);
				contadorAgua -= (0.095 * 5);
				contadorXaropeFanta -= (0.005 * 5);
				contador500Fanta += 5.00;
				copos500Fanta += 1;
				return true;
			}else {
				JOptionPane.showMessageDialog(null, "Não é possível servir. Verifique o nível dos ingredientes ou escolha outro copo.");
			}
		}else if(escolha == 3) {
			if(verificarNivel700Fanta() == true) {
				contadorGas -= (1 * 7);
				contadorAgua -= (0.095 * 7);
				contadorXaropeFanta -= (0.005 * 7);
				contador700Fanta += 8.25;
				copos700Fanta += 1;
				return true;
			}else {
				JOptionPane.showMessageDialog(null, "Não é possível servir. Verifique o nível dos ingredientes ou escolha outro copo.");
			}
		}else if(escolha == 0) {
			break;
		}else {
			JOptionPane.showMessageDialog(null, "Operação inválida.");
		}
	}
	return false;
}
}
