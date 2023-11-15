package br.com.vainaweb.backendt1.exercicios;

import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;

public class MegaSena {

	public static void main(String[] args) {
		int pontos = 0;
		int vet[] = new int[7];
		int resposta[] = {2, 4, 5, 2, 7, 8, 1};
		byte i = 0;
		int num = 0;
		boolean test = false;
		boolean loop = false;
		
		Scanner input = new Scanner(System.in);
		Random generator = new Random();
		
		for(i = 0; i <= 6 ;i++) {
			 resposta[i] = generator.nextInt(100);
		}
		
		
		for(i = 0; i<= 6; i++) {
			do { // VERIFICAR SE O NUMERO É MAIOR QUE 100.
				
				do { // VERIFICAR SE A ENTRADA DE DADOS É VÁLIDA.
					try {
						loop = true;
						System.out.println("Escolha seu "+ (i+1)+ "º numero: ");
						num = input.nextInt();
					}catch(InputMismatchException erro) {
						System.err.println("Tipo de entrada inválida digite um numero inteiro");
						loop = false;
						input.next();
					}
				}while(loop == false);
				if(num < 100) {
					vet[i] = num;
					test = true;
				}else {
					System.out.println("Numero maior que 100! Digite um numero válido");
				}
			}while(test == false);
		}
		input.close();
		
		for(i = 0; i<= 6; i++) {
			if(vet[i] == resposta[i]) {
				pontos = pontos + 1;
			}
		}
		
		System.out.printf("O resultado foi: %s, sua escolha foi: %s%n%n",
						Arrays.toString(resposta), Arrays.toString(vet));
		pontuacao(pontos);
		
	} //FIM DA MAIN
	
	static void pontuacao(int pontos) {
		switch(pontos) {
		case 5:
				System.out.println("Parabéns você conseguiu um prêmio de R$10.000");
			break;
		case 6:
				System.out.println("Parabéns você conseguiu um prêmio de R$50.000");
			break;
		case 7:
				System.out.println("Parabéns você conseguiu um prêmio de R$200.000");
			default:
				System.out.println("Infelizmente você não conseguiu nenhum prêmio");
		}
		
	}
}
