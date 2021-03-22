package com.alisson.refri;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Condicoes {

	int ligar;
	
	SistemaMáquina maquina = new SistemaMáquina();
	
	DecimalFormat df = new DecimalFormat("#.##");

	public void Menu() {
		
		
		if(ligar() == true) {
			
			int escolha = 1;
			
			while(escolha != 1 || escolha != 2 || escolha != 3 || escolha != 4 || escolha != 5 || escolha != 6 || escolha != 7 || escolha != 8 || escolha != 0) {
				
				escolha = Entrada.leiaInt("Digite uma opção: \n\n"
										+ "1 - Servir Coca-Cola\n"
										+ "2 - Servir Fruki guaraná\n"
										+ "3 - Servir Fanta laranja\n\n"
										+ "4 - Abastecer água\n"
										+ "5 - Abastecer xarope\n"
										+ "6 - Abastecer gás\n\n"
										+ "7 - Verificar níveis\n"
										+ "8 - Relatório de vendas\n\n"
										+ "0 - Sair");
				
				if(escolha == 1) {
					if(maquina.verificarNiveis() == false && maquina.verificarNivel300Coca() == false) {
						JOptionPane.showMessageDialog(null, "Operação inválida. Verifique o nível dos ingredientes.");
					}else if(maquina.escolherCopoCoca() == true) {
						JOptionPane.showMessageDialog(null, "Copo de Coca-Cola servido.");
					}
				}else if(escolha == 2) {
					if(maquina.verificarNiveis() == false && maquina.verificarNivel300Fruki() == false) {
						JOptionPane.showMessageDialog(null, "Operação inválida. Verifique o nível dos ingredientes.");
					}else if(maquina.escolherCopoFruki() == true) {
						JOptionPane.showMessageDialog(null, "Copo de Fruki guaraná servido.");
					}
				}else if(escolha == 3) {
					if(maquina.verificarNiveis() == false && maquina.verificarNivel300Fanta() == false) {
						JOptionPane.showMessageDialog(null, "Operação inválida. Verifique o nível dos ingredientes.");
					}else if(maquina.escolherCopoFanta() == true) {
						JOptionPane.showMessageDialog(null, "Copo de Fanta laranja servido.");
					}
				}else if(escolha == 4) {
					maquina.agua = Entrada.leiaDouble("Quanto você deseja abastecer? (Máximo 100 litros)");
					if(maquina.abastecerAgua() == false) {
						JOptionPane.showMessageDialog(null, "Operação inválida.");
					}
				}else if(escolha == 5) {
					 maquina.abastecerXaropeRefri();
				}else if(escolha == 6) {
					maquina.gas = Entrada.leiaDouble("Quanto você deseja abastecer? (Máximo 100 doses)");
					if(maquina.abastecerGas() == false) {
						JOptionPane.showMessageDialog(null, "Operação inválida.");
					}
				}else if(escolha == 7) {
					
				    df.setRoundingMode(RoundingMode.UP);
				    
				    JOptionPane.showMessageDialog(null, "NÍVEL DOS INGREDIENTES "
														+ "\n\nÁgua: " + df.format(maquina.contadorAgua) + " litros"
														+ "\nGás: " + df.format(maquina.contadorGas) + " doses"
														+ "\n\nXAROPES"
														+ "\nXarope Coca: " + df.format(maquina.contadorXaropeCoca) + " litros"
														+ "\nXarope Fruki: " + df.format(maquina.contadorXaropeFruki) + " litros"
														+ "\nXarope Fanta: " + df.format(maquina.contadorXaropeFanta) + " litros");   
				}else if(escolha == 8) {
					relatorioVendas();
				}else if(escolha == 0) {
					System.exit(1);
				}
			}
		}
	}
		
	public boolean ligar() {
					
		while(ligar != 1 || ligar != 2) {	
		
			ligar = Entrada.leiaInt("Deseja ligar a máquina? "
							       + "\n\n1 - Ligar | 2 - Sair");
			if(ligar == 1) {
				return true;
			}
			if(ligar == 2) {
				System.exit(1);
			} 
		}
		return false;
		}
	
	public void relatorioVendas() {
		
		int escolha = 1;
		
		while(escolha != 1 || escolha != 2 || escolha != 0) {
			
			escolha = Entrada.leiaInt("Digite uma opção: \n\n"
									+ "1 - Relatório contagem copos\n"
									+ "2 - Relatório financeiro\n"
									+ "\n0 - Sair");
			
			if(escolha == 1) {
				JOptionPane.showMessageDialog(null, "COPOS VENDIDOS"
				           + "\n\nCOCA-COLA"
				           + "\n300 ml: " + maquina.copos300Coca + " unidades"
				           + "\n500 ml: " + maquina.copos500Coca + " unidades"
				           + "\n700 ml: " + maquina.copos700Coca + " unidades"
				           + "\n\nFRUKI GUARANÁ"
				           + "\n300 ml: " + maquina.copos300Fruki + " unidades"
				           + "\n500 ml: " + maquina.copos500Fruki + " unidades"
				           + "\n700 ml: " + maquina.copos700Fruki + " unidades"
				           + "\n\nFANTA LARANJA"
				           + "\n300 ml: " + maquina.copos300Fanta + " unidades"
				           + "\n500 ml: " + maquina.copos500Fanta + " unidades"
				           + "\n700 ml: " + maquina.copos700Fanta + " unidades"
				           + "\n\nTOTAL: " + maquina.somatorioCopos() + " unidades");
			}else if(escolha == 2) {
				JOptionPane.showMessageDialog(null,"VALORES"
				           + "\n\nCOCA-COLA"
				           + "\n300 ml: " + maquina.contador300Coca + " reais"
				           + "\n500 ml: " + maquina.contador500Coca + " reais"
				           + "\n700 ml: " + maquina.contador700Coca + " reais"
				           + "\n\nFRUKI GUARANÁ"
				           + "\n300 ml: " + maquina.contador300Fruki + " reais"
				           + "\n500 ml: " + maquina.contador500Fruki + " reais"
				           + "\n700 ml: " + maquina.contador700Fruki + " reais"
				           + "\n\nFANTA LARANJA"
				           + "\n300 ml: " + maquina.contador300Fanta + " reais"
				           + "\n500 ml: " + maquina.contador500Fanta + " reais"
				           + "\n700 ml: " + maquina.contador700Fanta + " reais"
				           + "\n\nTOTAL: " + maquina.valorTotal() + " reais");
			}else if(escolha == 0) {
				break;
			}
		}
	}
}
